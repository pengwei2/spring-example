package com.example.transaction.service.declarative;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 20:55
 */
public class XmlMyService {

  JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public int doUpdate() {
    int result = jdbcTemplate.update("update t set v=? where k=?", "n", "k1");
    int i = 1 / 0;
    return result;
  }
}
