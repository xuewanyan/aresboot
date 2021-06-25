package com.cn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath*:META-INF/spring/spring-*.xml"})
public class StartSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartSpringBootApplication.class,args);
    }

}
