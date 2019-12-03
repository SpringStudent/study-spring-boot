package ning.zhou.study.springboot.studyspringboot.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author 周宁
 * @Date 2019-12-03 9:09
 */
@Service(interfaceClass = IHelloService.class)
@Component
public class IHelloServiceImpl implements IHelloService {

    @Override
    public void printStr(String str) {
        System.out.println(str);
    }

    @Override
    public void thinkingjava() {
        System.out.println(111);
    }

    @Override
    public String retStr() {
        return "123";
    }

    @Override
    public String testsd() {
        return "跟";
    }

    @Override
    public String halou() {
        return "{map}";
    }
}
