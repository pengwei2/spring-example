package com.example.aop.service.anno;

import com.example.aop.anno.Aop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/21 22:24
 */
@Component
@Aop
@Slf4j(topic = "spring-aop-test")
public class AnnotationService {

  public void method(){
    log.debug("@Aop AnnoWithinService method \n");
  }

  public void method2(){
    log.debug("@Aop AnnoWithinService method2 \n");
  }

}
