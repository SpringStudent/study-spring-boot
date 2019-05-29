package ning.zhou.study.springboot.studyspringboot.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author 周宁
 * @Date 2019-05-17 13:47
 */
@Slf4j
@Component
public class AsyncTask {

    public static Random random = new Random();

    @Async("taskExecutor")
    public void buy(CountDownLatch latch) {
        System.out.println(Thread.currentThread().getName()+"大脸猫去超市买菜");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {

        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"买好菜了,耗时" + (end - start) + "毫秒");
        latch.countDown();
    }

    @Async("taskExecutor")
    public void wash(CountDownLatch latch)  {
        System.out.println(Thread.currentThread().getName()+"猫大脸在家刷锅");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {

        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"刷好锅了,耗时" + (end - start) + "毫秒");
        latch.countDown();
    }

    @Async("taskExecutor")
    public void cleaning(CountDownLatch latch)  {
        System.out.println(Thread.currentThread().getName()+"脸猫大在家打扫");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {

        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"打扫了,耗时" + (end - start) + "毫秒");
        latch.countDown();
    }
}
