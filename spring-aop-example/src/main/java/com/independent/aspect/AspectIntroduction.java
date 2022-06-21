package com.independent.aspect;

import com.example.aop.service.introduction.thridparty.ThirdPartyOperation;
import com.example.aop.service.introduction.thridparty.impl.OpenOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 22:42
 */
@Component
@Aspect
@Slf4j(topic = "spring-aop-test")
public class AspectIntroduction {

  @DeclareParents(value = "com.example.aop.service.introduction.inner.impl.InnerServiceImpl"
      , defaultImpl = OpenOperation.class)
  public static ThirdPartyOperation thirdPartyOperation;
}
