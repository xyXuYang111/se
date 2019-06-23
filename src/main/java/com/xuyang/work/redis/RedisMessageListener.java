package com.xuyang.work.redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuy
 * @Date: 2019/4/17 00:17
 * @Description:
 */
@Data
@Slf4j
@Component
public class RedisMessageListener implements MessageListener {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        //信息内容
        String msgBody = (String) redisTemplate.getValueSerializer().deserialize(body);
        log.debug("信息内容:" + msgBody);
        //节点
        byte[] channel = message.getChannel();
        String msgChannel = (String) redisTemplate.getValueSerializer().deserialize(channel);
        log.debug("信息内容:" + msgChannel);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message){
        log.debug("消息内容");
        redisTemplate.convertAndSend("chat", message);
    }
}
