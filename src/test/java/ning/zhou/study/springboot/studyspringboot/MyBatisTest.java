package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 周宁
 * @Date 2019-05-21 19:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyBatisTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        userMapper.insert("sb",100);
        Map<String,Object> model = new HashMap<>();
        model.put("name","cxg");
        model.put("age",102);
        userMapper.insertByMap(model);
        System.out.println(userMapper.findByName("sb"));
        System.out.println(userMapper.findByName("cxg"));

        userMapper.delete("sb");
        userMapper.delete("cxg");
    }
}
