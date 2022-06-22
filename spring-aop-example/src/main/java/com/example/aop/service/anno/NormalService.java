package com.example.aop.service.anno;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/21 22:24
 */
@Component
@Slf4j(topic = "spring-aop-test")
public class NormalService {

  public void method(){
    log.debug("Normal AnnoWithinServiceNormal \n");
  }

}
