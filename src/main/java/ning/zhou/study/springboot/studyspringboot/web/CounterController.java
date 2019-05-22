package ning.zhou.study.springboot.studyspringboot.web;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 周宁
 * @Date 2019-05-22 11:38
 */
@RestController
@RequestMapping("/counter")
public class CounterController {

    @Resource
    private CounterService counterService;

    @GetMapping("/hello")
    public String greet() {
        counterService.increment("didispace.hello.count");
        return "";
    }
}
