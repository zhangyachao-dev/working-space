package com.zyc.aop.pointcut;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangyachao
 */
@Slf4j
@Component
@Aspect
public class AroundTest {

    @Pointcut("execution(* com.zyc.aop.service.TestService.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object operateAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        for (int a = 0; a < args.length - 1; a++) {
            log.info("AOP参数{}：{}", a +1, args[a]);
        }
        log.info("执行的参数：{}", args);
        Object arg = args[0];
        List<Object> objects = Lists.newArrayList();
        objects.add("我把参数改变了");
        Object proceed = point.proceed(objects.toArray());
        log.info("执行结果：{}", proceed);
        return proceed;
    }

}
