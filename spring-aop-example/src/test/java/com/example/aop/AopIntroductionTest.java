package com.example.aop;

import com.example.aop.service.introduction.inner.InnerService;
import com.example.aop.service.introduction.thridparty.ThirdPartyOperation;
import com.independent.aspect.AspectIntroduction;
import com.independent.config.AppJdkProxyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 22:45
 */
public class AopIntroductionTest {

  /*
     通过引介增强，可以为目标类添加一个接口的实现。即原来目标类未实现某个接口，通过引介增强可以为目标类创建实现某接口的代理
   */
  @Test
  public void testIntroductionAop() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(AppJdkProxyConfig.class);
    context.registerBean(AspectIntroduction.class);
    context.refresh();

    InnerService innerService = context.getBean(InnerService.class);
    innerService.doBusiness();

    ThirdPartyOperation thirdPartyOperation = (ThirdPartyOperation) innerService;
    thirdPartyOperation.doOperation();
  }
}
