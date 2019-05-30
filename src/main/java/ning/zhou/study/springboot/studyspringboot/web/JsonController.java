package ning.zhou.study.springboot.studyspringboot.web;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import ning.zhou.study.springboot.studyspringboot.dao.TbJsonDao;
import ning.zhou.study.springboot.studyspringboot.domain.TbJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 周宁
 * @Date 2019-05-30 17:15
 */
@RestController
@RequestMapping("/json")
public class JsonController {

    @Resource
    private TbJsonDao tbJsonDao;
    @GetMapping("/getJson")
    public Dtes getJson() throws Exception {
        Dtes res = new Dtes();
        TbJson tbJson = tbJsonDao.queryOne(1);
        res.setId(tbJson.getId());
        res.setJson(JSON.parseObject(tbJson.getJstr(),Map.class));
        return res;
    }

    @Data
    static class Dtes{

        private Map json;

        private Integer id;
    }
}
