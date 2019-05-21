package ning.zhou.study.springboot.studyspringboot.dao;

import com.gysoft.jdbc.dao.EntityDaoImpl;
import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author 周宁
 * @Date 2019-05-16 13:05
 */
@Repository
public class UserDaoImpl extends EntityDaoImpl<User,Long> implements UserDao {
}
