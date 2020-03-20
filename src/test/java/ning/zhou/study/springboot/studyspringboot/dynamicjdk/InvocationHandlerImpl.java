package ning.zhou.study.springboot.studyspringboot.dynamicjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object object;

    public InvocationHandlerImpl(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("asadasda");
        method.invoke(object,args);
        System.out.println("sdasdasada");
        return null;
    }


}
