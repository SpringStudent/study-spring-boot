package ning.zhou.study.springboot.studyspringboot;

import ning.zhou.study.springboot.studyspringboot.dao.TbUserDao;
import ning.zhou.study.springboot.studyspringboot.dao.UserDao2;
import ning.zhou.study.springboot.studyspringboot.domain.PageParam;
import ning.zhou.study.springboot.studyspringboot.domain.TbUser;
import ning.zhou.study.springboot.studyspringboot.domain.User;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周宁
 * @Date 2019-05-20 19:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private UserDao2 userDao2;

    @Autowired
    private TbUserDao tbUserDao;


    @Test
    public void test() {
        Assert.assertEquals(3, userDao2.findAll().size());
        Assert.assertEquals("wang", userDao2.findByName("wang").getName());
        Assert.assertEquals("wang", userDao2.findUser("wang").getName());
        Assert.assertNull(userDao2.findByNameAndAge("wag", 22));
    }

    @Test
    public void test2() {
        PageParam pageParam = new PageParam();
        pageParam.setSearchMobile("12345678901");
        pageParam.setSearchName("ins1");
        String searchId = pageParam.getSearchId();
        String searchName = pageParam.getSearchName();
        String searchMobile = pageParam.getSearchMobile();

        System.out.println(tbUserDao.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(searchName)) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + "%"));
            }
            if (StringUtils.isNotBlank(searchId)) {
                list.add(criteriaBuilder.equal(root.get("id").as(Long.class), searchId));
            }
            if (StringUtils.isNotBlank(searchMobile)) {
                list.add(criteriaBuilder.like(root.get("mobile").as(String.class), "%" + searchMobile + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }));
        int pageSize = pageParam.getPageSize();
        int pageNum = pageParam.getPageNum()-1;
        Sort sort = new Sort(Sort.Direction.DESC,"birth");
        PageRequest pageRequest = new PageRequest(pageNum,pageSize,sort);
        Page<TbUser> tbUserPage = tbUserDao.findAll(pageRequest);
        System.out.println(tbUserPage.getContent());
    }
}
