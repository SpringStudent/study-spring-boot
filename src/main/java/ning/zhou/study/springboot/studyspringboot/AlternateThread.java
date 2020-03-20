package ning.zhou.study.springboot.studyspringboot;

import java.util.concurrent.CyclicBarrier;

public class AlternateThread {
    static final CyclicBarrier threshold = new CyclicBarrier(4);

    public static void main(String[] args) {
        new PrintThread("A",0).start();
        new PrintThread("B",1).start();
        new PrintThread("C",2).start();
        new PrintThread("D",3).start();
    }

    static class PrintThread extends Thread {

        private String printStr;

        private int numberWaiting;

        public PrintThread(String printStr,int numberWaiting){
            this.printStr = printStr;
            this.numberWaiting = numberWaiting;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    if (threshold.getNumberWaiting() == numberWaiting) {
                        System.out.println(printStr);
                        threshold.await();
                    }
                }catch (Exception e){
                }
            }
        }
    }


}
