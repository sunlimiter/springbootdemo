package com.tywho.controller;

import com.tywho.entity.RequestMessage;
import com.tywho.entity.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lty on 2018/2/2/0002.
 */
@Controller
public class WsController {
    @RequestMapping("/ws")
    public String index() {
        return "/ws";
    }

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }
}