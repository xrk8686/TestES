package com.kelly;

import com.kelly.entity.listener.MyEntityListener;
import com.kelly.web.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by XU on 2017/7/1.
 */
@SpringBootApplication
@EnableTransactionManagement
@PropertySource(ignoreResourceNotFound=true,value="classpath:application.properties")
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

    @Bean
    public FilterRegistrationBean dawsonApiFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public MyEntityListener createMyEntityListener(){
        return new MyEntityListener();
    }
}
