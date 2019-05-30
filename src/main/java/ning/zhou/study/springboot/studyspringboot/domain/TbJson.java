package ning.zhou.study.springboot.studyspringboot.domain;

import com.gysoft.jdbc.annotation.Table;
import lombok.Data;

/**
 * @author 周宁
 * @Date 2019-05-30 17:13
 */
@Data
@Table(name = "tb_json")
public class TbJson {

    private Integer id;

    private String jstr;
}
