package com.xuyang.work.redis;

import com.xuyang.work.redis.listener.RedisMessageListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class RedisMessageListenerTest {

    @Autowired
    private RedisMessageListener redisMessageListener;

    @Test
    public void sendMessage() {
        redisMessageListener.sendMessage("消息测试");
    }
}
