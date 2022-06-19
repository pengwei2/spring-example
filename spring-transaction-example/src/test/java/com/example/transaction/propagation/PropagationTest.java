package com.example.transaction.propagation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.example.transaction.config.App;
import com.example.transaction.service.propagation.PropagationService1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 22:27
 */
public class PropagationTest {

  private AnnotationConfigApplicationContext context;

  @Before
  public void initContext() {
    context = new AnnotationConfigApplicationContext(App.class);
  }

  @Test
  public void testPropagationFollowRequired() {
    PropagationService1 service1 = context.getBean(PropagationService1.class);
    assertThat(service1.doUpdateFollowRequired(), greaterThan(1));
  }


  /**
   * <p>Suspending current transaction1, creating new transaction2</p>
   *
   * <p>tx1 update t set field0 where filed1</p>
   * <p>如果where 的 field1他不是一个索引字段就会执行表锁</p>
   * <p>如果where 的 field1加了注释则是行锁</p>
   */
  @Test
  public void testPropagationFollowRequiresNew() {
    PropagationService1 service1 = context.getBean(PropagationService1.class);
    assertThat(service1.doUpdateFollowRequiresNew(), greaterThan(1));
  }

  @Test
  public void testPropagationFollowRequiresNew2() {
    PropagationService1 service1 = context.getBean(PropagationService1.class);
    assertThat(service1.doUpdateFollowRequiresNew2(), greaterThan(1));
  }

  @Test
  public void testPropagationFollowRequiresNew3() {
    PropagationService1 service1 = context.getBean(PropagationService1.class);
    assertThat(service1.doUpdateFollowRequiresNew3(), greaterThan(1));
  }

  @Test
  public void testPropagationFollowNested() {
    PropagationService1 service1 = context.getBean(PropagationService1.class);
    assertThat(service1.doUpdateFollowNested(), greaterThan(1));
  }
}
