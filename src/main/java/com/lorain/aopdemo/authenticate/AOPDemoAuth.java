package com.lorain.aopdemo.authenticate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AOPDemoAuth {

    @Pointcut("execution(* com.lorain.aopdemo.controller.*.*(..))")
    public void rest() {
    }

    @Around("rest()")
    public Object httpAuth(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()) {
            System.out.println("no permission!");
            return "no permission";
        }
        Object obj = joinPoint.proceed();
        System.out.println("rest execute done");
        return obj;
    }

}

