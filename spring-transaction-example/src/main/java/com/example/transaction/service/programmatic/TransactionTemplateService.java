package com.example.transaction.service.programmatic;

import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 20:10
 */
@Component
public class TransactionTemplateService {

  @Resource
  TransactionTemplate transactionTemplate;

  @Resource
  JdbcTemplate jdbcTemplate;

  public int doUpdate() {
    final int[] result = {0};

    transactionTemplate.execute(new TransactionCallbackWithoutResult(){

      @Override
      protected void doInTransactionWithoutResult(TransactionStatus status) {
        try {
          result[0] += jdbcTemplate.update("update t set v=? where k=?", "n", "k1");

          // 产生一个ArithmeticException
          int i = 1/0;

          result[0] += jdbcTemplate.update("update t set v=? where k=?", "n", "k2");
        } catch (DataAccessException e) {
          e.printStackTrace();
          status.setRollbackOnly();
        }
      }
    });

    return result[0];
  }
}
