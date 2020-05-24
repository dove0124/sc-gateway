package cn.springcloud.cloudgrpcclient;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import net.devh.boot.grpc.client.interceptor.GlobalClientInterceptorConfigurer;

@Order
@Configuration
public class GlobalClientInterceptorConfiguration {

    @Bean
    public GlobalClientInterceptorConfigurer globalInterceptorConfigurerAdapter() {
        return registry -> registry.addClientInterceptors(new LogGrpcInterceptor());
    }
}
