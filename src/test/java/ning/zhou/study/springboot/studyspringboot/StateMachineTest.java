package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.statemachine.Events;
import ning.zhou.study.springboot.studyspringboot.statemachine.States;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 周宁
 * @Date 2019-05-21 20:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StateMachineTest {

    @Resource
    private StateMachine<States,Events> stateMachine;

    @Test
    public void test(){
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);

        stateMachine.sendEvent(Events.RECIEVE);
    }
}
