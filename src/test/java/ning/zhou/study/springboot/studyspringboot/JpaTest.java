package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.dao.UserDao2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周宁
 * @Date 2019-05-20 19:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private UserDao2 userDao2;

    @Test
    public void test(){
        Assert.assertEquals(3,userDao2.findAll().size());
        Assert.assertEquals("wang",userDao2.findByName("wang").getName());
        Assert.assertEquals("wang",userDao2.findUser("wang").getName());
        Assert.assertNull(userDao2.findByNameAndAge("wag",22));
    }
}
