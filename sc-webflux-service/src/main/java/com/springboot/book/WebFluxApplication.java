package com.springboot.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**** imports ****/
// 定义扫描包
//@SpringBootApplication(scanBasePackages = "com.springboot.book")
//@SpringBootApplication
@SpringCloudApplication
// 由于引入JPA，默认的情况下，需要配置数据源，
// 通过@EnableAutoConfiguration排除原有自动配置的数据源
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
// 在WebFlux下，驱动MongoDB的JPA接口
@EnableReactiveMongoRepositories(
    // 定义扫描的包
    basePackages = "com.springboot.book.repository")
public class WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }
}
