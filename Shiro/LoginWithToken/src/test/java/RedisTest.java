

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@ContextConfiguration(classes = com.example.config.RedisConfig.class)
public class RedisTest {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Test
    public void test() throws InterruptedException {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "孟晨", 60, TimeUnit.SECONDS);
        Thread.sleep(60001);
        String name = (String) valueOperations.get("name");
        Assert.assertNull(name);
        System.out.println(name);
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("程序正在运行：" + jedis.ping());
//        jedis.set("name", "孟晨");
//        jedis.expire("name", 60);
//        Thread.sleep(60001);
//        String name = jedis.get("name");
//        Assert.assertNull(name);
    }
}