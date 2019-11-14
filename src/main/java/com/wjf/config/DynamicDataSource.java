package com.wjf.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源，设置数据源自动调用该类方法
 * @created by 24745
 * @date 2019/11/11
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }

}
