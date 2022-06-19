package com.example.transaction.service.programmatic;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 18:07
 */
@Component
public class PlatformTransactionManagerService {

  @Resource
  PlatformTransactionManager transactionManager;

  @Resource
  JdbcTemplate jdbcTemplate;

  public int doUpdate() {
    DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
    definition.setName("PlatformTransactionManagerService事务");

    TransactionStatus transactionStatus = transactionManager.getTransaction(definition);

    int result = 0;
    try {
      result += jdbcTemplate.update("update t set v='n' where k='k1'");

      // 产生一个ArithmeticException
      int i = 1 / 0;

      result += jdbcTemplate.update("update t set v='n' where k='k2'");
      transactionManager.commit(transactionStatus);
    } catch (Exception e) {
      e.printStackTrace();
      transactionManager.rollback(transactionStatus);
    }
    return result;
  }
}
