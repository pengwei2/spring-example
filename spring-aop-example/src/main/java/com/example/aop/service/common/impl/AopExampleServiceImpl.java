package com.example.aop.service.common.impl;

import com.example.aop.service.common.AopExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 16:23
 */
@Slf4j(topic = "spring-aop-test")
@Component
public class AopExampleServiceImpl implements AopExampleService {

  @Override
  public void method() {
    log.debug("general method \n");
  }

  @Override
  public void methodIntegerArgs(Integer i) {
    log.debug("methodIntegerArgs integer:[{}] \n", i);
  }

  @Override
  public void methodIntegerMultiArgs(Integer i, String s) {
    log.debug("methodIntegerMultiArgs integer:[{}] string[{}] \n", i, s);
  }
}
