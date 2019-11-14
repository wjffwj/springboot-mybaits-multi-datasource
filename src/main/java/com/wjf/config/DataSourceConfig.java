package com.wjf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @created by 24745
 * @date 2019/11/11
 */
@Configuration
public class DataSourceConfig {
    /**
     * 从库数据源
     * @return
     */
    @Bean("readTestDb")
    @ConfigurationProperties(prefix = "spring.datasource.read-test-db")
    public DataSource readTestDb() {
        return DataSourceBuilder.create().build();
    }
    /**
     * 主库数据源
     * @return
     */
    @Bean("writeTestDb")
    @ConfigurationProperties(prefix = "spring.datasource.write-test-db")
    public DataSource writeTestDb() {
        return DataSourceBuilder.create().build();
    }
    /**
     * 动态数据源根据AOP在不同的数据源中切换
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(readTestDb());
        //配置多数据源
        Map<Object,Object> dsMap = new HashMap<>();
        dsMap.put("readTestDb",readTestDb());
        dsMap.put("writeTestDb",writeTestDb());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置transaction注解事务
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return  new DataSourceTransactionManager(dynamicDataSource());
    }


}
