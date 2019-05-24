package ning.zhou.study.springboot.studyspringboot.service;

import com.gysoft.jdbc.bean.Criteria;
import com.gysoft.jdbc.bean.SQL;
import ning.zhou.study.springboot.studyspringboot.dao.UserDao;
import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.gysoft.jdbc.bean.FuncBuilder.count;

/**
 * @author 周宁
 * @Date 2019-05-16 13:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void create(String name, Integer age)throws Exception {
        userDao.insertWithSql(new SQL().insert(User::getName,User::getAge).values(name,age));
    }

    @Override
    public void deleteByName(String name) throws Exception{
        userDao.deleteWithCriteria(new Criteria().where(User::getName,name));
    }

    @Override
    public Integer getAllUsers() throws Exception{
        return userDao.queryIntegerWithSql(new SQL().select(count("*")).from(User.class));
    }

    @Override
    public void deleteAllUsers() throws Exception{
        userDao.deleteWithCriteria(new Criteria());
    }

    @Override
    public List<User> getUserList() throws Exception {
        return userDao.queryAll();
    }
}
