package com.kelly.app;

import io.searchbox.client.JestClient;
import io.searchbox.core.Get;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by XU on 2017/4/23.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            JestClient jestClient = (JestClient) ctx.getBean("jestClient");
            Get get = new Get.Builder("twitter", "1").type("tweet").build();
            jestClient.execute(get);
            System.out.println(jestClient);

        };
    }
}
