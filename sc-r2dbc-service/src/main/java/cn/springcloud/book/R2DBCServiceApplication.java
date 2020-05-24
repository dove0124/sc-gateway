package cn.springcloud.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import cn.springcloud.book.controller.PersonController;

@SpringCloudApplication
//@SpringBootApplication
public class R2DBCServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(R2DBCServiceApplication.class, args);
    }
}
