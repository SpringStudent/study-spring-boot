package ning.zhou.study.springboot.studyspringboot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 周宁
 * @Date 2019-05-17 11:10
 */
@Component
@Data
public class IProperties {
    @Value("${ning.zhou.user}")
    private String name;
    @Value("${ning.zhou.age}")
    private Integer age;
    @Value("${ning.zhou.user.info}")
    private String info;
}
