package com.example.aop.service.introduction.thridparty.impl;

import com.example.aop.service.introduction.thridparty.ThirdPartyOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 22:34
 */
@Slf4j(topic = "spring-aop-test")
public class OpenOperation implements ThirdPartyOperation {

  @Override
  public void doOperation() {
    log.debug("do open operation");
  }
}
