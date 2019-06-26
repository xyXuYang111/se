package com.xuyang.work.controller;

import com.xuyang.work.redis.listener.RedisMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class SendController {

    @Autowired
    private RedisMessageListener redisMessageListener;

    @ResponseBody
    @RequestMapping(value = "sendMessageController", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    public String sendMessageController(){
        log.debug("发送消息");
        String msg = "发送消息";
        redisMessageListener.sendMessage(msg);
        return "发送消息：" + msg;
    }
}