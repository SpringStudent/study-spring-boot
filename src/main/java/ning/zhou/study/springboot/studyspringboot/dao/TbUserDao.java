package ning.zhou.study.springboot.studyspringboot.dao;

import ning.zhou.study.springboot.studyspringboot.domain.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 周宁
 * @Date 2019-05-24 9:33
 */
public interface TbUserDao extends JpaRepository<TbUser,Long>,JpaSpecificationExecutor<TbUser> {
}
