package com.example.model;

import com.example.aop.anno.Aop;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/21 22:14
 */
@Aop
public class MyParameterAnnotation {

  @Override
  public String toString() {
    return "MyParameterAnnotation";
  }
}
