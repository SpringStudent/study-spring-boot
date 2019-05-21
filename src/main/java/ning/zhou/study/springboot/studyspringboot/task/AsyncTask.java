package ning.zhou.study.springboot.studyspringboot.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author 周宁
 * @Date 2019-05-17 13:47
 */
@Component
public class AsyncTask {

    public static Random random = new Random();

    @Async
    public void buy() throws InterruptedException {
        System.out.println("大脸猫去超市买菜");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("买好菜了,耗时" + (end - start) + "毫秒");
    }

    @Async
    public void wash() throws InterruptedException {
        System.out.println("猫大脸在家刷锅");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("刷好锅了,耗时" + (end - start) + "毫秒");
    }

    @Async
    public void cleaning() throws InterruptedException {
        System.out.println("脸猫大在家打扫");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("打扫了,耗时" + (end - start) + "毫秒");
    }
}
