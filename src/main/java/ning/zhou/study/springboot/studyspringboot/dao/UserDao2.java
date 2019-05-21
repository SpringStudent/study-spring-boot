package ning.zhou.study.springboot.studyspringboot.dao;

import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 周宁
 * @Date 2019-05-20 19:40
 */
public interface UserDao2 extends JpaRepository<User,Long> {

    User findByName(String name);

    User findByNameAndAge(String name,Integer age);
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
