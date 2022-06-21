package com.example.aop;

import com.example.aop.service.common.AopExampleOtherService;
import com.example.aop.service.common.AopExampleService;
import com.example.aop.service.common.impl.CommonService;
import com.example.aop.service.introduction.inner.InnerService;
import com.independent.aspect.AspectArgs;
import com.independent.aspect.AspectPackage;
import com.independent.aspect.AspectPackageAndArgs;
import com.independent.aspect.AspectTarget;
import com.independent.aspect.AspectThis;
import com.independent.config.AppCglibProxyConfig;
import com.independent.config.AppDefaultConfig;
import com.independent.config.AppJdkProxyConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 16:24
 */
public class AopCommonTest {

  private AnnotationConfigApplicationContext context;

  @Before
  public void initContext() {
    context = new AnnotationConfigApplicationContext();
  }

  @After
  public void testAspect() {
    context.refresh();

    // AopExampleService
    AopExampleService service = context.getBean(AopExampleService.class);
    service.method();
    service.methodIntegerArgs(2);
    service.methodIntegerMultiArgs(3, "3");

    // AopExampleOtherService
    AopExampleOtherService otherService = context.getBean(AopExampleOtherService.class);
    otherService.methodOther();

    // CommonService
    CommonService commonService = context.getBean(CommonService.class);
    commonService.method();
    commonService.methodIntegerMultiArgs(3, "3");

    // InnerService
    InnerService innerService = context.getBean(InnerService.class);
    innerService.doBusiness();
    innerService.doBusiness(3, "3");
  }

  /*
      动态代理影响的类范围为com.example.aop.service.common包以及子包下所有的类
   */
  @Test
  public void testPackageAop() {
    context.register(AppDefaultConfig.class);
    context.registerBean(AspectPackage.class);
  }


  /*
      动态代理影响的类范围为spring容器种所有bean的带有(Integer,String)签名的方法
   */
  @Test
  public void testArgsAop() {
    context.register(AppDefaultConfig.class);
    context.registerBean(AspectArgs.class);
  }

  /*
      动态代理影响的类范围为com.example.aop.service.common包以及子包下所有的类中，带有(Integer,String)签名的方法
   */
  @Test
  public void testPackageAndArgsAop() {
    context.register(AppDefaultConfig.class);
    context.registerBean(AspectPackageAndArgs.class);
  }


  /*
     1、默认接口的动态代理为JDK动态代理
     2、代理类型按类型匹配于指定类
     3、而这个代理类是AopExampleOtherService的实现类，与AopExampleOtherServiceImpl类型不匹配
   */
  @Test
  public void testThisAopWithJdkProxy() {
    context.register(AppJdkProxyConfig.class);
    context.registerBean(AspectThis.class);
  }


  /*
    1、默认接口的动态代理为Cglib动态代理
    2、代理类型按类型匹配于指定类
    3、而这个代理类是AopExampleOtherServiceImpl类型的子类，所以该代理类与AopExampleOtherServiceImpl类型匹配
  */
  @Test
  public void testThisAopWithCglibProxy() {
    context.register(AppCglibProxyConfig.class);
    context.registerBean(AspectThis.class);
  }


  /*
    假如目标类按类型匹配指定类，则目标类的所有连接点匹配这个切点
   */
  @Test
  public void testTargetAop() {
    context.register(AppDefaultConfig.class);
    context.registerBean(AspectTarget.class);
  }


}
