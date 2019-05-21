package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周宁
 * @Date 2019-05-21 19:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private Sender sender;

    @Test
    public void hello(){
        sender.send();
    }
}
