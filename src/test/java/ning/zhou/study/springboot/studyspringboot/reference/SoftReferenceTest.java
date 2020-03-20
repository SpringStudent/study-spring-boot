package ning.zhou.study.springboot.studyspringboot.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> studentSoftReference=new SoftReference(new byte[1024*1024*10]);
        System.out.println(studentSoftReference.get());
        System.gc();
        System.out.println(studentSoftReference.get());

        byte[] bytes = new byte[1024*1024*10];
        System.out.println(studentSoftReference.get());
    }
}
