package ning.zhou.study.springboot.studyspringboot.domain;

import lombok.Data;

/**
 * @author 周宁
 * @Date 2019-05-23 21:00
 */
@Data
public class PageParam {

    private Integer pageSize = 10;
    private Integer pageNum = 1;

    private String searchName;

    private String searchMobile;

    private String searchId;
}
