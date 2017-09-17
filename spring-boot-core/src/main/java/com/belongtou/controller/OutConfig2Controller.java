package com.belongtou.controller;/**
 * Created by Administrator on 2017/9/17.
 */

import com.belongtou.model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yll
 * @Description
 * @Date 2017-09-17
 **/
@RestController
@ConfigurationProperties(prefix = "author")
public class OutConfig2Controller {

    Logger logger = LoggerFactory.getLogger(OutConfig2Controller.class);

    @Autowired
    private Author author;

    @RequestMapping("/authorInfo")
    public String authorInfo() {
        logger.info("开始执行 autoorInfo 方法，获取的配置信息为"+author);
        return "author name is:" + author.getName() + " and age is:" + author.getAge();
    }
}
