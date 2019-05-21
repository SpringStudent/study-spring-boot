package ning.zhou.study.springboot.studyspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周宁
 * @Date 2019-05-17 11:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IPropertiesConfig {

    @Autowired
    private IProperties iProperties;

    @Test
    public void getI(){
        System.out.println(iProperties.getAge());
        System.out.println(iProperties.getName());
        System.out.println(iProperties.getInfo());
    }
}
