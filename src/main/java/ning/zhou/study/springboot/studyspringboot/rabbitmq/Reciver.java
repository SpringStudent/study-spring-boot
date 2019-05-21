package ning.zhou.study.springboot.studyspringboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 周宁
 * @Date 2019-05-21 19:48
 */
@Component
@RabbitListener(queues = "hello")
public class Reciver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Reciver:" + hello);
    }
}
