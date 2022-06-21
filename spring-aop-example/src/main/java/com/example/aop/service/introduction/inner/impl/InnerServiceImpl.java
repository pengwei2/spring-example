package com.example.aop.service.introduction.inner.impl;

import com.example.aop.service.introduction.inner.InnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 22:40
 */
@Slf4j(topic = "spring-aop-test")
@Component
public class InnerServiceImpl implements InnerService {

  @Override
  public void doBusiness() {
    log.debug("do business \n");
  }

  @Override
  public void doBusiness(Integer i, String s) {
    log.debug("doBusiness integer:[{}] string[{}] \n", i, s);
  }
}
