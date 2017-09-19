package com.belngtou;/**
 * Created by Administrator on 2017/9/19.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author yll
 * @Description
 * @Date 2017-09-19
 **/
@Configuration
@EnableWebSocketMessageBroker
// @EnableWebSocketMessageBroker表示开启使用Stomp协议  来传输基于代理(MessageBroker)的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    // 配置消息代理(MessageBroker)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    // 注册协议节点(endpoint)，指定映射的URl,指定使用的协议是SockJS
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/my-websocket").withSockJS();
    }
}
