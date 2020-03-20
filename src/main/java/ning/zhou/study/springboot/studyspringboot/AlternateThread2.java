package ning.zhou.study.springboot.studyspringboot;

import java.util.ArrayList;
import java.util.List;

public class AlternateThread2 {
    static List<String> printStr;
    static final Object lock = new Object();

    static {
        initArrayList();
    }

    private static void initArrayList() {
        printStr = new ArrayList<>();
        printStr.add("A");
        printStr.add("B");
        printStr.add("C");
        printStr.add("D");
    }

    public static void main(String[] args) {
        new PThread().start();
        new PThread().start();
        new PThread().start();
        new PThread().start();
    }

    static class PThread extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    System.out.println(printStr.get(0));
                    printStr.remove(0);
                    if (printStr.isEmpty()) {
                        initArrayList();
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }

        }
    }
}
