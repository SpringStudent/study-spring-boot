package ning.zhou.study.springboot.studyspringboot.web;

import com.gysoft.sso.bean.GyBasicSession;
import ning.zhou.study.springboot.studyspringboot.aspect.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周宁
 * @Date 2019-05-16 11:10
 */
@RestController
public class HelloController extends GyBasicSession {

    @GetMapping("/hello")
    @RateLimit
    public String index(){
        System.out.println(getUserName());
        return "hello world";
    }
}
