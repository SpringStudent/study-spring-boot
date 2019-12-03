package ning.zhou.study.springboot.studyspringboot.web;

import com.alibaba.fastjson.JSON;
import com.gysoft.sso.bean.GyBasicSession;
import ning.zhou.study.springboot.studyspringboot.aspect.RateLimit;
import ning.zhou.study.springboot.studyspringboot.matrix.Matrix;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 周宁
 * @Date 2019-05-16 11:10
 */
@RestController
public class HelloController extends GyBasicSession {

    @GetMapping("/hello")
    @RateLimit
    public String index(){
        System.out.println(getUserName());
        return "hello world";
    }

    @GetMapping("/myArr")
    public String[] myArr(){
        String[] arr = {"a","b","c"};
        return arr;
    }

    @GetMapping("/myArr2")
    public String[][] myArr2(){
        String[][] arr = {{"a","b","c"},{"d","e","f"}};
        System.out.println(arr[1][2]);

        return arr;
    }

    @GetMapping("/matrix")
    public Matrix matrix(){
        double[][] asd = new double[][]{{1,2,3},{4,6,7}};
        return new Matrix(asd);
    }

    @PostMapping("/matrixParam")
    public void matrixParam(@RequestBody double[][] psd){
        Matrix matrix = new Matrix(psd);
        System.out.println(matrix);
    }

    @PostMapping("/mapParam")
    public void mapParam(@RequestBody Map map){
        System.out.println(JSON.toJSONString(map));
    }

}
