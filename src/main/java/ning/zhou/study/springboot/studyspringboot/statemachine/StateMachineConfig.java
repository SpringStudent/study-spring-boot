package ning.zhou.study.springboot.studyspringboot.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * @author 周宁
 * @Date 2019-05-21 19:58
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {
    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates().initial(States.UNPAID)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions.withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Events.PAY).and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECIEVE);
    }

    //使用注解的方式实现与下面注释掉的代码相同的功能见EventConfig
    /*@Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration()
                .listener(listener());
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListener<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> state, State<States, Events> state1) {

            }

            @Override
            public void stateEntered(State<States, Events> state) {

            }

            @Override
            public void stateExited(State<States, Events> state) {

            }

            @Override
            public void eventNotAccepted(Message<Events> message) {

            }

            @Override
            public void transition(Transition<States, Events> transition) {
                if (transition.getTarget().getId() == States.UNPAID) {
                    System.out.println("订单创建,待支付");
                    return;
                }

                if (transition.getSource().getId() == States.UNPAID
                        && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
                    System.out.println("用户完成支付，待收货");
                    return;
                }

                if (transition.getSource().getId() == States.WAITING_FOR_RECEIVE
                        && transition.getTarget().getId() == States.DONE) {
                    System.out.println("用户已收货，订单完成");
                    return;
                }
            }

            @Override
            public void transitionStarted(Transition<States, Events> transition) {

            }

            @Override
            public void transitionEnded(Transition<States, Events> transition) {

            }

            @Override
            public void stateMachineStarted(StateMachine<States, Events> stateMachine) {

            }

            @Override
            public void stateMachineStopped(StateMachine<States, Events> stateMachine) {

            }

            @Override
            public void stateMachineError(StateMachine<States, Events> stateMachine, Exception e) {

            }

            @Override
            public void extendedStateChanged(Object o, Object o1) {

            }

            @Override
            public void stateContext(StateContext<States, Events> stateContext) {

            }

        };
    }*/
}


