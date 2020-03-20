package ning.zhou.study.springboot.studyspringboot.reference;

public class StrongReferenceTest {

    public static void main(String[] args) {
        Student student = new Student();
        student = null;
        System.gc();
    }
}
