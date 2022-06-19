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
public class PropagationService1 {

  @Resource
  JdbcTemplate jdbcTemplate;

  @Resource
  PropagationService2 service2;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int doUpdateFollowRequired() {
    int result = 0;
    result += jdbcTemplate.update("update t set v=? where k=?", "n1", "k1");
    result += service2.doUpdateWithRequired();
    return result;
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int doUpdateFollowRequiresNew() {
    int result = 0;
    result += jdbcTemplate.update("update t set v=? where k=?", "n1", "k1");
    result += service2.doUpdateWithRequiresNew();
    return result;
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int doUpdateFollowRequiresNew2() {
    int result = 0;
    result += jdbcTemplate.update("update t set v=? where i=?", "n1", "i1");
    result += service2.doUpdateWithRequiresNew2();
    return result;
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int doUpdateFollowRequiresNew3() {
    int result = 0;
    result += jdbcTemplate.update("update t set v=? where i=?", "n1", "i1");
    result += service2.doUpdateWithRequiresNew3();
    return result;
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int doUpdateFollowNested() {
    int result = 0;
    result += jdbcTemplate.update("update t set v=? where i=?", "n1", "i1");

    int i = 1 / 0;

    result += service2.doUpdateWithNested();
    return result;
  }

}
