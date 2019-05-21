package ning.zhou.study.springboot.studyspringboot.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 周宁
 * @Date 2019-05-21 19:46
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello "+new Date();
        System.out.println("Sender:"+context);
        amqpTemplate.convertAndSend("hello",context);
    }
}
