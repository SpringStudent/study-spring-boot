package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.domain.User;
import ning.zhou.study.springboot.studyspringboot.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周宁
 * @Date 2019-05-17 10:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoDbTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        userRepository.deleteAll();
    }

    @Test
    public void test(){
        userRepository.save(new User(1L,"zhouning",26));
        userRepository.save(new User(2L,"pengjiajia",27));
        userRepository.save(new User(3L,"hexiaofei",24));

        Assert.assertEquals(3,userRepository.findAll().size());

        User u = userRepository.findOne(1L);
        userRepository.delete(u);
        Assert.assertEquals(2,userRepository.findAll().size());

        System.out.println(userRepository.findByName("pengjiajia"));

    }
}
