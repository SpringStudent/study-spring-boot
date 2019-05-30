package ning.zhou.study.springboot.studyspringboot.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * @author 周宁
 * @Date 2019-05-16 11:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JacksonXmlRootElement(localName = "User")
public class User implements Serializable {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JacksonXmlProperty(localName = "id")
    private Long id;
    @Column(nullable = false)
    @JacksonXmlProperty(localName = "name")
    private String name;
    @Column(nullable = false)
    @JacksonXmlProperty(localName = "age")
    private Integer age;
}
