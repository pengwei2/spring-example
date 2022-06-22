package com.independent.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/21 22:21
 */
@Component
@Aspect
@Slf4j(topic = "spring-aop-test")
public class AspectAnnotation {

  @Pointcut("@annotation(com.example.aop.anno.Aop)")
  public void pointCutAnnoWithin(){

  }

  @Before("pointCutAnnoWithin()")
  public void adviceBefore(){
    log.debug("before aop");
  }
}
