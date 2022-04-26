package aspects_homework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
    private int counter = 0;
    @Value("${spring.max_api_requests}")
    private int MAX_COUNT;

    @Around(value = "execution(public * aspects_homework.Controller.*(..))")
    public Object addCount(ProceedingJoinPoint pjp) throws IllegalAccessException {
        if (counter < MAX_COUNT) {
            counter++;
            try {
                return pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        throw new IllegalAccessException();
    }
}
