package com.example.transaction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.example.transaction.config.App;
import com.example.transaction.service.MyService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 17:31
 */
public class JdbcTemplateTest {

  @Test
  public void testJdbcTemplate() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    MyService bean = context.getBean(MyService.class);
    assertThat(bean.doUpdate(), greaterThan(0));
  }
}
