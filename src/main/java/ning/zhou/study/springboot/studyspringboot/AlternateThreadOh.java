package ning.zhou.study.springboot.studyspringboot;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class AlternateThreadOh {
    static Integer base = 1;
    static final CyclicBarrier barrier = new CyclicBarrier(2);
    static final CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        new PrintThread(0,"T-1").start();
        new PrintThread(1,"T-2").start();
        countDownLatch.await();
        System.out.println(System.currentTimeMillis()-start+"ms");
    }

    static class PrintThread extends Thread {
        private int number;
        private String name;
        public PrintThread(int number,String name) {
            this.number = number;
            this.name = name;
        }

        @Override
        public void run() {
            while (base<=1000000) {
                    if (barrier.getNumberWaiting()==number) {
                        System.out.println(name+"线程输出:"+base++);
                        try {
                            barrier.await();
                        } catch (InterruptedException e) {
                        } catch (BrokenBarrierException e) {
                        }
                    }
            }
            countDownLatch.countDown();
        }
    }
}
