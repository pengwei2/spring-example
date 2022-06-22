package com.example.aop.service.anno;

import com.example.aop.anno.Aop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/22 9:07
 */
@Component
@Slf4j(topic = "spring-aop-test")
public class AnnotationMethodService {

  @Aop
  public void method(){
    log.debug("AnnotationMethodService method \n");
  }

}
