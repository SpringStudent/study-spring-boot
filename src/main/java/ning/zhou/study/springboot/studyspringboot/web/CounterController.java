package ning.zhou.study.springboot.studyspringboot.web;

import lombok.Data;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/maps")
    public Maps maps(){
        Maps maps = new Maps();
        Map a = new HashMap();
        a.put("1",1L);

        maps.setA(a);
        Map b = new HashMap();
        a.put("1",2L);
        maps.setB(b);
        return maps;
    }


    @Data
    public static class Maps{
        private Map<String,Long> a;
        private Map<String,Long> b;

    }
}
