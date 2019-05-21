package ning.zhou.study.springboot.studyspringboot.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author 周宁
 * @Date 2019-05-21 20:14
 */
@WithStateMachine
public class EventConfig {

    @OnTransition(target = "UNPAID")
    public void create(){
        System.out.println("订单创建，待支付");
    }

    @OnTransition(source = "UNPAID",target = "WAITING_FOR_RECEIVE")
    public void pay(){
        System.out.println("用户完成支付，待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE",target = "DONE")
    public void recieve(){
        System.out.println("用户已收货，订单完成");
    }

}
