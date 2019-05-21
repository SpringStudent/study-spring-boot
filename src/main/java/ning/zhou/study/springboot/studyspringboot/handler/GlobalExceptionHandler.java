package ning.zhou.study.springboot.studyspringboot.handler;

import ning.zhou.study.springboot.studyspringboot.except.MyException;
import ning.zhou.study.springboot.studyspringboot.tool.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 周宁
 * @Date 2019-05-17 10:22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "500_error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception e, HttpServletRequest req) throws Exception {
        Map<String,Object> model = new HashMap<>();
        model.put("exception", e);
        model.put("url", req.getRequestURL());
        return new ModelAndView(DEFAULT_ERROR_VIEW,model);
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Result<Object> myExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        return Result.fail(e.getMessage());
    }

}
