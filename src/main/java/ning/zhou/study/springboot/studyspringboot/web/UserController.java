package ning.zhou.study.springboot.studyspringboot.web;

import ning.zhou.study.springboot.studyspringboot.domain.User;
import ning.zhou.study.springboot.studyspringboot.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author 周宁
 * @Date 2019-05-16 11:34
 */
@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    @PostMapping("/")
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @PostMapping("/{id}")
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

    @Resource
    private UserService userService;

    @PutMapping("/create")
    public void create(@RequestParam String name,@RequestParam Integer age) throws Exception {
        userService.create(name, age);
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name) throws Exception {
        userService.deleteByName(name);
    }

    @GetMapping("/getAllUsers")
    public Integer getAllUsers() throws Exception {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteAllUsers")
    public void deleteAllUsers() throws Exception {
        userService.deleteAllUsers();
    }

    @GetMapping("/getUserList2")
    public List<User> getUserList2() throws Exception {
        return userService.getUserList();
    }

    @PostMapping(value = "/formatUser",consumes = MediaType.APPLICATION_XML_VALUE, produces =MediaType.APPLICATION_XML_VALUE )
    public User formatUser(@RequestBody User user){
        user.setName("your name is"+user.getName());
        user.setAge(user.getAge());
        return user;
    }
}
