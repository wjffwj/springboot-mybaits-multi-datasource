package com.wjf.config;

/**
 * 数据源切换读取类
 * @created by 24745
 * @date 2019/11/11
 */

public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "readTestDb";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    //设置数据源名
    public static void setDB(String dbType) {
        System.out.println("切换到数据源"+dbType);
        contextHolder.set(dbType);
    }

    //获取数据源名
    public static String getDB() {
        return contextHolder.get();
    }

    //清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
