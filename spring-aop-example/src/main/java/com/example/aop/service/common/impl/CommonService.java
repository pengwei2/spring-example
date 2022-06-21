package com.example.aop.service.common.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 21:28
 */
@Slf4j(topic = "spring-aop-test")
@Component
public class CommonService {

  public void method() {
    log.debug("common service, without sub class \n");
  }

  public void methodIntegerMultiArgs(Integer i, String s) {
    log.debug("methodIntegerMultiArgs integer:[{}] string[{}] \n", i, s);
  }
}
