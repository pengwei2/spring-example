package com.example.transaction.service.propagation;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 22:10
 */
@Component
public class PropagationService2 {

  @Resource
  JdbcTemplate jdbcTemplate;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int doUpdateWithRequired() {
    int update = jdbcTemplate.update("update t set v=? where k=?", "n2", "k2");
    return update;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  public int doUpdateWithRequiresNew() {
    return jdbcTemplate.update("update t set v=? where k=?", "n2", "k2");
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  public int doUpdateWithRequiresNew2() {
    return jdbcTemplate.update("update t set v=? where i=?", "n2", "i2");
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  public int doUpdateWithRequiresNew3() {
    return jdbcTemplate.update("update t set v=? where i=?", "n2", "i1");
  }

  @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
  public int doUpdateWithNested() {
    return jdbcTemplate.update("update t set v=? where i=?", "n2", "i1");
  }
}
