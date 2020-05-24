package cn.springcloud.book.dataservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.springcloud.book.dataservice.intercepter.DataInterceptor;

@Configuration
@EnableWebMvc
public class DataConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 请求拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DataInterceptor());
    }
}
