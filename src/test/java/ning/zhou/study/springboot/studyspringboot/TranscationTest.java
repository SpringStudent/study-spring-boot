package ning.zhou.study.springboot.studyspringboot;

import com.gysoft.jdbc.bean.Criteria;
import ning.zhou.study.springboot.studyspringboot.dao.UserDao;
import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 周宁
 * @Date 2019-05-17 15:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TranscationTest {

    @Autowired
    private UserDao userDao;


    @Test
    @Transactional
    public void test() throws Exception {
        userDao.save(new User(4L,"li",29));
        userDao.save(new User(5L,"wang",29));
        userDao.save(new User(6L,"cheng",29));
        userDao.save(new User(7L,"dddddddddd",29));
    }
}
