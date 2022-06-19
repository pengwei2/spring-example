package com.example.transaction.service.declarative;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 21:33
 */
@Component
public class AnnotationMyService {

  @Resource
  JdbcTemplate jdbcTemplate;

  @Transactional(rollbackFor = Exception.class)
  public int doUpdate() {
    int result = jdbcTemplate.update("update t set v=? where k=?", "n", "k1");
    int i = 1 / 0;
    return result;
  }
}
