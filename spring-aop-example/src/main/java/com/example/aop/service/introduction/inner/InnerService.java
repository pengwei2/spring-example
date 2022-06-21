package com.example.aop.service.introduction.inner;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/20 22:39
 */
public interface InnerService {

  /**
   * 完成自身业务逻辑
   */
  void doBusiness();

  /**
   * 完成自身业务逻辑
   * @param i 整数入参
   * @param s 字符串入参
   */
  void doBusiness(Integer i, String s);
}
