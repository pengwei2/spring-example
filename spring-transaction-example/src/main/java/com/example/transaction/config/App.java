package com.example.transaction.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author pw
 * @version 1.0
 * @date 2022/6/18 17:13
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.example.transaction")
public class App {

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }


  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setPassword("root");
    dataSource.setUsername("root");
    dataSource.setUrl(
        "jdbc:mysql://localhost:3306/spring-example?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");

    return dataSource;
  }

  /**
   * 使用Spring JDBC 或 MyBatis等基于DataSource数据源的持久化技术时，使用该事务管理器
   */
  @Bean
  public PlatformTransactionManager transactionManager() {
    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
    dataSourceTransactionManager.setDataSource(dataSource());
    return dataSourceTransactionManager;
  }

  /**
   * 使用Spring JDBC 或 MyBatis等基于DataSource数据源的持久化技术时，使用该事务管理器
   */
  @Bean
  public TransactionTemplate transactionTemplate() {
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    transactionTemplate.setTransactionManager(transactionManager());
    return transactionTemplate;
  }
}
