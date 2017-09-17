package com.belongtou;/**
 * Created by Administrator on 2017/9/17.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yll
 * @Description 使用@Value("${xxx}") 获取外部配置
 * @Date 2017-09-17
 **/
@RestController
@SpringBootApplication
public class OutConfig {

    @Value("${book.author}")
    private String author;

    @Value("${book.name}")
    private String name;

    @RequestMapping("/")
    public String index() {
        return "book name is :" + name + ", and book author is :" + author;
    }

    public static void main(String[] args) {
        SpringApplication.run(OutConfig.class, args);
    }
}
