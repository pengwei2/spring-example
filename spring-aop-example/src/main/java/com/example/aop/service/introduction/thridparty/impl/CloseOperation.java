package com.example.aop.service.introduction.thridparty.impl;

import com.example.aop.service.introduction.thridparty.ThirdPartyOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 22:35
 */
@Slf4j(topic = "spring-aop-test")
public class CloseOperation implements ThirdPartyOperation {

  @Override
  public void doOperation() {
    log.debug("do close operation");
  }
}
