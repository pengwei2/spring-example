package com.independent.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 15:44
 */
@Component
@Aspect
@Slf4j(topic = "spring-aop-test")
public class AspectArgs {

  @Pointcut("args(Integer,String)")
  public void pointCutArgs() {
  }

  @Before("pointCutArgs()")
  public void adviceBeforeCase() {
    log.info("before aop");
  }


}
