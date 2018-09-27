package top.mcwebsite.concurrency.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * @author mengchen
 * @time 18-9-16 下午7:23
 */
public class Mutex {
    /**
     * 静态内部类，自定义同步器
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 是否处于独占状态
         * @return
         */
        protected boolean isHeldExeclusively() {
            return getState() == 1;
        }

        /**
         * 当状态为0的时候获取锁
         * @param acquires
         * @return
         */
        @Override
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                // 设置当前线程拥有独占访问线程的权限
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int release) {
            if (getState() == 0) {
                // 抛出的异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器而本身没有指定监视器的线程。
                throw new IllegalMonitorStateException();
            }
            // null表示放弃对该线程的锁定
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 返回一个Condition，每一个condition都包含了一个condition队列
         * @return
         */
        Condition newCondition() {
            return new ConditionObject();
        }
    }


    /**
     * 仅需要将操作代理到Sync上即可
     */
    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void tryLock() {
        sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLock() {
        return sync.isHeldExeclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

}
