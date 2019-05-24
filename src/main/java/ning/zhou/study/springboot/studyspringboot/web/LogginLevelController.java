package ning.zhou.study.springboot.studyspringboot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周宁
 * @Date 2019-05-22 17:21
 */
@RestController
@RequestMapping("/log")
public class LogginLevelController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/test")
    public void testLogLevel(){
        logger.debug("Logger level: debugger");
        logger.info("Logger level: info");
        logger.error("Logger level: error");
    }
}
