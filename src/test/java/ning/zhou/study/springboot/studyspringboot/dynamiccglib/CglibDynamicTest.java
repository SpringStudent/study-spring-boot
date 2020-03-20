package ning.zhou.study.springboot.studyspringboot.dynamiccglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibDynamicTest {

    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        Hacker hacker = new Hacker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(programmer.getClass());
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();

    }
}
