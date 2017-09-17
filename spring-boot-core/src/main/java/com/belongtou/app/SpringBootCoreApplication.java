package com.belongtou.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.belongtou")
public class SpringBootCoreApplication {

    @RequestMapping("/hello")
    public String hello(String word) {
        return "hello" + word;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCoreApplication.class, args);
    }
}
