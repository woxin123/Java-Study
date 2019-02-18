package top.mcwebsite.studyredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mengchen
 * @time 19-1-28 下午4:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void cluster() {
        for (int i = 0; i < 100; i++) {
            redisTemplate.opsForValue().set(i + "", i + "     ");
        }
    }
}
