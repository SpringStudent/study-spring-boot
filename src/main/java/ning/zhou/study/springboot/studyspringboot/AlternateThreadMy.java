package ning.zhou.study.springboot.studyspringboot;

import java.util.concurrent.CountDownLatch;

public class AlternateThreadMy {

    static int base = 1;
    static final Object lock = new Object();
    static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        new OddThread().start();
        new EvenThread().start();
        countDownLatch.await();
        System.out.println(System.currentTimeMillis()-start+"ms");
    }

    static class OddThread extends Thread{

        @Override
        public void run() {
            while (base<=1000000){
                synchronized (lock){
                    if(base%2==1){
                        System.out.println("奇数线程"+base++);
                        lock.notify();
                        try {
                            if(base>=999999){
                                countDownLatch.countDown();
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    static class EvenThread extends Thread{
        @Override
        public void run() {
            while (base<=1000000){
                synchronized (lock){
                    if(base%2==0){
                        System.out.println("偶数线程"+base++);
                        lock.notify();
                        try {
                            if(base>=999999){
                                countDownLatch.countDown();
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
