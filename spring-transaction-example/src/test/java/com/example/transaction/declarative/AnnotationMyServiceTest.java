package com.example.transaction.declarative;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.example.transaction.config.App;
import com.example.transaction.service.declarative.AnnotationMyService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 21:34
 */
public class AnnotationMyServiceTest {

  @Test
  public void testAnnotationTx() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(App.class);
    AnnotationMyService bean = context.getBean(AnnotationMyService.class);
    assertThat(bean.doUpdate(), greaterThan(0));
  }
}
