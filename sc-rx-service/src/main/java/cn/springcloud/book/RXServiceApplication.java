package cn.springcloud.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@MapperScan({"cn.springcloud.book.mapper"})
public class RXServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RXServiceApplication.class, args);
    }
}
