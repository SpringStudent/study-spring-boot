package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.task.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周宁
 * @Date 2019-05-17 13:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void test() throws InterruptedException {
        asyncTask.wash();
        asyncTask.buy();
        asyncTask.cleaning();
    }
}
