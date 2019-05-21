package ning.zhou.study.springboot.studyspringboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 周宁
 * @Date 2019-05-17 13:39
 */
@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("现在时间:"+dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void cronTest(){
        System.out.println("老铁双击666");
    }
}
