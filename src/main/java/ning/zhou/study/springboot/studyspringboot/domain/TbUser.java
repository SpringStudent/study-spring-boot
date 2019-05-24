package ning.zhou.study.springboot.studyspringboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 周宁
 * @Date 2019-05-24 9:31
 */
@Entity(name = "tb_user")
@Data
public class TbUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String name;
    private String realName;
    private String pwd;
    private String email;
    private String mobile;
    private Date birth;
    private Integer age;
    private String career;
    @Column(nullable = false,name = "isActive")
    private Integer isActive;
    private Integer roleId;
}
