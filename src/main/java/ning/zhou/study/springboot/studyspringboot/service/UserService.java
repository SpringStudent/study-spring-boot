package ning.zhou.study.springboot.studyspringboot.service;

import ning.zhou.study.springboot.studyspringboot.domain.User;

import java.util.List;

/**
 * @author 周宁
 * @Date 2019-05-16 13:06
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age)throws Exception;

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name)throws Exception;

    /**
     * 获取用户总量
     */
    Integer getAllUsers()throws Exception;

    /**
     * 删除所有用户
     */
    void deleteAllUsers()throws Exception;

    List<User> getUserList()throws Exception;
}
