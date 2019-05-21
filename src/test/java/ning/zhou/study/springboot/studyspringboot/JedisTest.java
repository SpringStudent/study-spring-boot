package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周宁
 * @Date 2019-05-17 9:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aaa","123");
        Assert.assertEquals("123",stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test2(){
        User user =new User(1L,"zhouning",26);
        redisTemplate.opsForValue().set(user.getName(),user);

        user = new User(2L,"pengjiajia",27);
        redisTemplate.opsForValue().set(user.getName(),user);

        Assert.assertEquals(26,redisTemplate.opsForValue().get("zhouning").getAge().longValue());
        Assert.assertEquals(27,redisTemplate.opsForValue().get("pengjiajia").getAge().longValue());
    }
}
