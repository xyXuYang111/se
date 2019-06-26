package com.xuyang.work.controller;

import com.xuyang.work.logger.model.Logger;
import com.xuyang.work.redis.listener.RedisMessageListener;
import com.xuyang.work.redis.RedisService;
import com.xuyang.work.redis.redisRepository.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
public class MessageController {

    @Autowired
    private RedisMessageListener redisMessageListener;

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping(value = "redisMessageController", method = RequestMethod.GET)
    public String redisMessageController(){
        log.debug("消息机制测试");
        redisMessageListener.sendMessage("测试消息");
        return "redis消息机制";
    }

    @ResponseBody
    @RequestMapping(value = "redisInsertController", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    public String redisInsertController(){
        log.debug("redis新增");
        Logger logger = new Logger();
        logger.setLogName("1111");
        redisService.set("xuyang", logger);
        Logger objectInfo = (Logger)redisService.get("xuyang");
        System.out.println(objectInfo.toString());
        return "redis新增" + objectInfo.toString();
    }

    @ResponseBody
    @RequestMapping(value = "redisObjectController", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    public String redisObjectController(){
        log.debug("redis新增对象");
        Logger logger = new Logger();
        logger.setLogName("1111");
        redisService.set("11111111", logger);
        Logger loggerInfo = (Logger)redisService.get("11111111");
        System.out.println(loggerInfo.toString());
        return "redis新增对象";
    }

    @ResponseBody
    @RequestMapping(value = "redisMapController", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    public String redisMapController(){
        log.debug("redis新增map对象");
        Logger logger = new Logger();
        logger.setLogName("1111");
        RedisRepository.insertMapRedis("11111111", "1", logger);
        RedisRepository.insertMapRedis("11111111", "2", logger);
        RedisRepository.insertMapRedis("11111111", "3", logger);
        RedisRepository.insertMapRedis("11111111", "4", logger);
        Map<Object, Object> map = RedisRepository.mapRedis("3");
        System.out.println(map.values());
        return "redis新增对象" + map.values();
    }
}