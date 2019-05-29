package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.task.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 周宁
 * @Date 2019-05-17 13:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {

    private static final CountDownLatch latch = new CountDownLatch(3);
    @Autowired
    private AsyncTask asyncTask;

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

    @Test
    public void test() throws IOException, InterruptedException {
        asyncTask.wash(latch);
        asyncTask.buy(latch);
        asyncTask.cleaning(latch);
        latch.await();
        taskExecutor.shutdown();
        System.in.read();
    }
}
