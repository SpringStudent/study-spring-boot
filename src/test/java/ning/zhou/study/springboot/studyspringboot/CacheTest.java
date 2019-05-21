package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.dao.UserDao2;
import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周宁
 * @Date 2019-05-21 9:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Autowired
    private UserDao2 userDao2;
    @Test
    public void testCache() {
        User u1 = userDao2.findByName("cheng");
        System.out.println("第一次查询：" + u1);

        User u2 = userDao2.findByName("cheng");
        System.out.println("第二次查询：" + u2);

        u2.setAge(20);
        userDao2.save(u2);

        User u3 =userDao2.findByName("cheng");
        System.out.println("第三次查询："+u3);
    }
}
