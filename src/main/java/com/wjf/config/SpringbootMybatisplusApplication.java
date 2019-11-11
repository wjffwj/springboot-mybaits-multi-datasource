package com.wjf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author weijunfeng
 * @date 2019/5/20
 */
@ComponentScan(basePackages = {"com.wjf"})
@MapperScan("com.wjf.mapper")
@SpringBootApplication
public class SpringbootMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusApplication.class, args);
    }

}
