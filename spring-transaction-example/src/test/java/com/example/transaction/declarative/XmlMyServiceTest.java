package com.example.transaction.declarative;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.example.transaction.service.declarative.XmlMyService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 20:56
 */
public class XmlMyServiceTest {

  @Test
  public void testXmlTx() {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("classpath:appTransaction4Xml.xml");
    XmlMyService bean = context.getBean(XmlMyService.class);
    assertThat(bean.doUpdate(), greaterThan(0));
  }

}
