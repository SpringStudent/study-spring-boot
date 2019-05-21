package ning.zhou.study.springboot.studyspringboot.dao;

import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 周宁
 * @Date 2019-05-20 19:40
 */
@CacheConfig(cacheNames = "users")
public interface UserDao2 extends JpaRepository<User,Long> {
    @Cacheable(key = "#p0")
    User findByName(String name);

    User findByNameAndAge(String name,Integer age);
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
    @CachePut(key = "#p0.name")
    User save(User user);
}
