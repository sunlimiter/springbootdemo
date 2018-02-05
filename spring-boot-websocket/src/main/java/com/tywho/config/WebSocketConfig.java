package com.tywho.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by lty on 2018/2/2/0002.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    //这个方法的作用是添加一个服务端点，来接收客户端的连接。
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //表示添加了一个/socket端点，客户端就可以通过这个端点来进行连接。
        stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();//withSockJS()的作用是开启SockJS支持，
    }

    //这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息。
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");//指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
    }
}
