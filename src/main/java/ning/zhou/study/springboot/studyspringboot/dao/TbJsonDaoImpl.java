package ning.zhou.study.springboot.studyspringboot.dao;

import com.gysoft.jdbc.dao.EntityDaoImpl;
import ning.zhou.study.springboot.studyspringboot.domain.TbJson;
import org.springframework.stereotype.Repository;

/**
 * @author 周宁
 * @Date 2019-05-30 17:14
 */
@Repository
public class TbJsonDaoImpl  extends EntityDaoImpl<TbJson,Integer> implements TbJsonDao {
}
