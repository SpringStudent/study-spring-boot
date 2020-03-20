package ning.zhou.study.springboot.studyspringboot.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhantomReferenceTest {

    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        List<byte[]> bytes = new ArrayList<>();
        PhantomReference<Student> reference = new PhantomReference<>(new Student(),queue);
        new Thread(()->{
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
                bytes.add(new byte[1024*1024]);
            }
        }).start();

        new Thread(()->{
            while (true){
                Reference poll = queue.poll();
                if(poll!=null){
                    System.out.println("虚引用被回收了:"+poll);
                }
            }
        }).start();
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
    }
}
