package com.belngtou;/**
 * Created by Administrator on 2017/9/19.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yll
 * @Description
 * @Date 2017-09-19
 **/
@Controller
@EnableScheduling
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // @SendTo 推送消息给订阅了/topic/send的路径的浏览器发送
    @MessageMapping("/send")
    @SendTo("/topic/send")
    public SocketMessageRequest send(SocketMessageRequest message) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.date = df.format(new Date());
        return message;
    }

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/callback")
    private Object callback() throws Exception {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
        return "callback";
    }


    // 服务端接受到消息以后，会对@SendTo中的地址传送消息。
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public SocketMessageResponse say(SocketMessageRequest request){
        return new SocketMessageResponse("Welcome, " + request.getMessage() + "!");
    }
}
