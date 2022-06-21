package com.example.aop.service.common.impl;

import com.example.aop.service.common.AopExampleOtherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 16:49
 */
@Slf4j(topic = "spring-aop-test")
@Component
public class AopExampleOtherServiceImpl implements AopExampleOtherService {

  @Override
  public void methodOther() {
    log.debug("aop example other service \n");
  }
}
