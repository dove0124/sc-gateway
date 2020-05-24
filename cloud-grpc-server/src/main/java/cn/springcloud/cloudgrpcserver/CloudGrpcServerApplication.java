package cn.springcloud.cloudgrpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudGrpcServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGrpcServerApplication.class, args);
    }
}
