package com.example.aop;

import com.example.aop.service.anno.AnnotationArgsService;
import com.example.aop.service.anno.AnnotationMethodService;
import com.example.aop.service.anno.AnnotationService;
import com.example.aop.service.anno.NormalService;
import com.example.model.MyParameter;
import com.example.model.MyParameterAnnotation;
import com.independent.aspect.AspectAnnoArgs;
import com.independent.aspect.AspectAnnoWithin;
import com.independent.aspect.AspectAnnotation;
import com.independent.config.AppDefaultConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/21 22:22
 */
public class AopAnnotationTest {

  private AnnotationConfigApplicationContext context;

  @Before
  public void initContext() {
    context = new AnnotationConfigApplicationContext();
  }

  @After
  public void testAspect() {
    context.refresh();

    AnnotationService annotationService = context.getBean(AnnotationService.class);
    annotationService.method();
    annotationService.method2();

    NormalService withinServiceNormal = context.getBean(NormalService.class);
    withinServiceNormal.method();

    AnnotationArgsService annotationArgsService = context.getBean(AnnotationArgsService.class);
    annotationArgsService.method1(new MyParameter());
    annotationArgsService.method2(new MyParameterAnnotation());
    annotationArgsService.method3(new MyParameterAnnotation(), 8);
    annotationArgsService.method4(new MyParameterAnnotation());

    AnnotationMethodService annotationMethodService = context
        .getBean(AnnotationMethodService.class);
    annotationMethodService.method();
  }


  /*
      @args(com.example.aop.anno.Aop)
      方法仅又一个参数，并且这个参数对象所属的类被@Aop注解标注
   */
  @Test
  public void testAnnoArgsAop() {
    context.register(AppDefaultConfig.class);
    context.register(AspectAnnoArgs.class);
  }


  /*
      @within(com.example.aop.anno.Aop)
      被@Aop注解标注类的所有方法
   */
  @Test
  public void testAnnoWithinAop() {
    context.register(AppDefaultConfig.class);
    context.register(AspectAnnoWithin.class);
  }

  /*
      @annotation(com.example.aop.anno.Aop)
      标注了特定注解的目标方法连接点
   */
  @Test
  public void testAnnotationAop() {
    context.register(AppDefaultConfig.class);
    context.register(AspectAnnotation.class);
  }


}
