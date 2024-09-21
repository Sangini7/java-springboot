package Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggerAspect.class);

    //return type, full classname.methodname(arguments)
    @Before("execution(* com.sangini.SpringBootRest.service.JobService*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName());
    }
    @After("execution(* com.sangini.SpringBootRest.service.JobService*(..))")
    public void logMethodExec(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName());
    }
    @AfterThrowing("execution(* com.sangini.SpringBootRest.service.JobService*(..))")
    public void logMethodThrow(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName());
    }
    @Around("execution(* com.sangini.SpringBootRest.service.JobService*(..))")
    public Object logMethodSuccess(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info(String.valueOf((start-end)));
        return obj;
    }
}
