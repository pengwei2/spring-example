package com.example.transaction.programmatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.example.transaction.config.App;
import com.example.transaction.service.programmatic.TransactionTemplateService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 20:09
 */
public class TransactionTemplateTest {

  @Test
  public void testTransactionTemplate() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(App.class);
    TransactionTemplateService bean = context.getBean(TransactionTemplateService.class);
    assertThat(bean.doUpdate(), greaterThan(1));
  }
}
