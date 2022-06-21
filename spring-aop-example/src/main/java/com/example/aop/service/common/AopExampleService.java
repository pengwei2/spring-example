package com.example.aop.service.common;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 16:00
 */
public interface AopExampleService {

  /**
   * 无参方法
   */
  void method();

  /**
   * 单个入参方法
   * @param i 整数入参
   */
  void methodIntegerArgs(Integer i);

  /**
   * 两个入参方法
   * @param i 整数入参
   * @param s 字符串入参
   */
  void methodIntegerMultiArgs(Integer i, String s);
}
