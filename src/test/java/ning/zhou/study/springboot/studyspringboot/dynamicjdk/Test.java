package ning.zhou.study.springboot.studyspringboot.dynamicjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        EletricCar car = new EletricCar();
        ClassLoader cs = car.getClass().getClassLoader();
        Class[] clssss = car.getClass().getInterfaces();
        InvocationHandler invc = new InvocationHandlerImpl(car);

        Object obj = Proxy.newProxyInstance(cs,clssss,invc);
        Vechile vechile = (Vechile) obj;
        vechile.drive();

        Rechargable rechargable = (Rechargable) obj;
        rechargable.recharge();
    }
}
