package ning.zhou.study.springboot.studyspringboot.dynamiccglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Hacker implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("sdsadsadsaa");
        methodProxy.invokeSuper(o,objects);
        System.out.println("sdasdadsa");
        return null;
    }
}
