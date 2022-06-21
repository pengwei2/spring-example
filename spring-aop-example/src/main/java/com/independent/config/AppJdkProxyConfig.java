package com.independent.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 11:25
 */
@Configuration
@ComponentScan(value = "com.example.aop")
@EnableAspectJAutoProxy
public class AppJdkProxyConfig {

  /*
      @EnableAspectJAutoProxy(proxyTargetClass = false)

      1、如果目标类是接口，则使用JDK动态代理
      2、如果目标类是普通类，则使用Cglib动态代理
      3、proxyTargetClass的值仅仅影响目标类是接口的场景下，spring框架选择哪种动态代理策略
   */
}
