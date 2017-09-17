package com.belongtou.model;/**
 * Created by Administrator on 2017/9/17.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yll
 * @Description 使用@ConfigurationProperties 加载配置文件的信息，可以指定文件位置
 * @Date 2017-09-17
 **/
@Component
@ConfigurationProperties(prefix = "author")
public class Author {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
