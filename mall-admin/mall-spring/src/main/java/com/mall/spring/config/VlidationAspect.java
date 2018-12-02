package com.mall.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 超
 * Create by fengc on  2018/12/2 22:48
 */
@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("com.mall.spring.config.LoggingAspect.declareJointPointExpression()")
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("-------validateArgs:【Arrays.asList(joinPoint.getArgs())】:" + Arrays.asList(joinPoint.getArgs()));
    }
}
