package ning.zhou.study.springboot.studyspringboot.web;

import ning.zhou.study.springboot.studyspringboot.aspect.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周宁
 * @Date 2019-05-16 11:10
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @RateLimit
    public String index(){
        return "hello world";
    }
}
