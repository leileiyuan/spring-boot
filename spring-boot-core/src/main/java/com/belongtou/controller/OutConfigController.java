package com.belongtou.controller;/**
 * Created by Administrator on 2017/9/17.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yll
 * @Description
 * @Date 2017-09-17
 **/
@RestController
public class OutConfigController {

    @Value("${book.author}")
    private  String author;

    @Value("${book.name}")
    private  String name;

    @RequestMapping("/bookInfo")
    public String bookInfo() {
        return "book name is:" + name + " and book author is:" + author;
    }
}
