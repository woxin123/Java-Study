package top.mcwebsite.mock;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import top.mcwebsite.studyredis.DistributedLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mengchen
 * @time 19-2-22 上午12:30
 */
public class DistributedLockMock {

    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMinIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        // todo borrow 是什么？
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
    }

    DistributedLock lock = new DistributedLock(pool);

    int n = 500;

    public void seckill() {
        // 返回锁的value，供释放的时候判断
        String identifier = lock.lockWithTimeout("resource", 5000, 1000);
        System.out.println(Thread.currentThread().getName() + "获取了锁");
        System.out.println(--n);
        lock.releaseLock("resource", identifier);
    }

    public static void main(String[] args) {
        DistributedLockMock distributedLockMock = new DistributedLockMock();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            executorService.submit(() -> {
                distributedLockMock.seckill();
            });
        }
        executorService.shutdown();
    }
}
