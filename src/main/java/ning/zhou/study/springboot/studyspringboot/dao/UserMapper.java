package ning.zhou.study.springboot.studyspringboot.dao;

import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * @author 周宁
 * @Date 2019-05-21 19:24
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(name,age) values(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO USER(name,age) values(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

    @Delete("DELETE FROM user WHERE name =#{name}")
    void delete(@Param("name") String name);
}
