package com.asimkilic.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Before("execution(* com.asimkilic.aop.service.*.*(..))")
    public void beforeGiveMessage(JoinPoint joinPoint) {
        System.out.println("Give Message metodundan önce yakalanan parametre: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }


    @After("execution(* com.asimkilic.aop.service.*.*(..))")
    public void afterGiveMessage(JoinPoint joinPoint) {
        System.out.println("Give Message metodundan sonra yakalanan parametre: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());

    }
}
