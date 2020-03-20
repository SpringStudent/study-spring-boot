package ning.zhou.study.springboot.studyspringboot.reference;

public class Student {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("我准备被回收了");
    }
}
