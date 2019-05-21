package ning.zhou.study.springboot.studyspringboot.repository;

import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 周宁
 * @Date 2019-05-17 10:01
 */
public interface UserRepository extends MongoRepository<User,Long> {

    User findByName(String name);
}
