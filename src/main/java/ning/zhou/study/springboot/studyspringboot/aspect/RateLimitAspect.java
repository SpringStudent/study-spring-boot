package ning.zhou.study.springboot.studyspringboot.aspect;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周宁
 * @Date 2019-05-24 11:28
 */
@Component
@Aspect
public class RateLimitAspect {

    @Resource
    private HttpServletResponse response;

    private RateLimiter rateLimiter = RateLimiter.create(2.0);

    @Pointcut("@annotation(ning.zhou.study.springboot.studyspringboot.aspect.RateLimit)")
    public void rateLimitePc() {

    }

    @Around("rateLimitePc()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Boolean flag = rateLimiter.tryAcquire();
        Object obj = null;
        try {
            if (flag) {
                obj = joinPoint.proceed();
            } else {
                obj = "接口调用频繁";
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("flag=" + flag + ",obj=" + obj);
        return obj;
    }


}
