package ning.zhou.study.springboot.studyspringboot.web;

import ning.zhou.study.springboot.studyspringboot.except.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 周宁
 * @Date 2019-05-16 11:26
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("host", "http://www.bigfacecat.site:827");
        return "index";
    }

    @RequestMapping("/except")
    public String except() throws Exception {
        throw new Exception("异常了");
    }

    @RequestMapping("/myExcept")
    public String myExcept() throws Exception {
        throw new MyException("我的异常");
    }
}
