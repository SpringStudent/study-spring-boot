package ning.zhou.study.springboot.studyspringboot.dao;

import com.gysoft.jdbc.dao.EntityDaoImpl;
import ning.zhou.study.springboot.studyspringboot.domain.TbEnumTest;
import org.springframework.stereotype.Repository;

/**
 * @author 周宁
 * @Date 2019-12-16 20:23
 */
@Repository
public class TbEnumTestDaoImpl extends EntityDaoImpl<TbEnumTest,String> implements TbEnumTestDao {
}
