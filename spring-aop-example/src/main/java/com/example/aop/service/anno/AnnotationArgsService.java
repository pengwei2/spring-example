package com.example.aop.service.anno;

import com.example.model.MyParameter;
import com.example.model.MyParameterAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/21 22:17
 */
@Component
@Slf4j(topic = "spring-aop-test")
public class AnnotationArgsService {

  public void method1(MyParameter p) {
    log.debug("method1[{}] \n", p);
  }

  public void method2(MyParameterAnnotation p) {
    log.debug("method2[{}] \n", p);
  }

  public void method3(MyParameterAnnotation p, Integer i) {
    log.debug("method3[{},{}] \n", p,i);
  }

  public void method4(MyParameterAnnotation p) {
    log.debug("method4[{}] \n", p);
  }


}
