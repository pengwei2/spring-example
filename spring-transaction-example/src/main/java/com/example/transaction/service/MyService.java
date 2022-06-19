package com.example.transaction.service;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 17:34
 */
@Component
public class MyService {

  @Resource
  JdbcTemplate jdbcTemplate;

  public int doUpdate() {
    return jdbcTemplate.update("update t set v=? where k=?", "n", "k1");
  }
}
