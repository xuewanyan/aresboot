package com.cn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@ImportResource(locations = {"classpath:META-INF/spring/spring-service.xml"})
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class StartSpringBootApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(StartSpringBootApplication.class,args);
    }

}
