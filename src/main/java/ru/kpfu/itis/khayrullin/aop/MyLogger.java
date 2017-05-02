package ru.kpfu.itis.khayrullin.aop;

import org.apache.log4j.BasicConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyLogger {

    private Logger log = Logger.getLogger(getClass());
    
    @Before("execution(* ru.kpfu.itis.khayrullin.controller.AdminController.*(..))")
    public void before() {
        System.out.println("РАБОТАЕТ!!!");
    }

    @After("execution(* ru.kpfu.itis.khayrullin.controller.AdminController.*(..))")
    public void log(JoinPoint point) {
        BasicConfigurator.configure();
        log.info(point.getSignature().getName() + " called...");
    }
}
