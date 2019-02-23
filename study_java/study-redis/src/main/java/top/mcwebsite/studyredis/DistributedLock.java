package top.mcwebsite.studyredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * Redis分布式锁
 *
 * @author mengchen
 * @time 19-2-21 下午9:41
 */
public class DistributedLock {

    private final JedisPool jedisPool;

    public DistributedLock(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 加锁
     *
     * @param lockName    锁的key
     * @param acquireTime 获取超时时间
     * @param timeout     锁的超时时间
     * @return
     */
    public String lockWithTimeout(String lockName, long acquireTime, long timeout) {
        Jedis conn = null;
        String retIdentifier = null;
        try {
            // 获取连接
            conn = this.jedisPool.getResource();
            // 随机生成一个key
            String identifier = UUID.randomUUID().toString();
            // 锁名，即key值
            String lockKey = "lock:" + lockName;
            // 设置超时时间
            int lockExpire = (int) timeout / 1000;

            // 获取锁的超时时间
            long end = System.currentTimeMillis() + acquireTime;
            while (System.currentTimeMillis() < end) {
                if (conn.setnx(lockKey, identifier) == 1) {
                    conn.expire(lockKey, lockExpire);
                    // 返回value值，用于释放锁
                    retIdentifier = identifier;
                    return retIdentifier;
                }
                // 返回-1表示没有设置超时时间
                if (conn.ttl(lockKey) == -1) {
                    conn.expire(lockKey, lockExpire);
                }

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return retIdentifier;
    }

    /**
     * 释放锁
     *
     * @param lockName
     * @param identifier
     * @return
     */
    public boolean releaseLock(String lockName, String identifier) {
        String lockKey = "lock:" + lockName;
        boolean retFlag = false;
        Jedis conn = jedisPool.getResource();
        try {
            while (true) {
                // 监视Lock，开始事务
                conn.watch(lockKey);
                // 通过与前面返回的value值做对比判断是不是该锁，若是该锁，则删除，释放锁
                if (identifier.equals(conn.get(lockKey))) {
                    Transaction transaction = conn.multi();
                    transaction.del(lockKey);
                    List<Object> results = transaction.exec();
                    if (results == null) {
                        continue;
                    }
                    retFlag = true;
                }
                conn.unwatch();
                break;
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return retFlag;
    }

}
