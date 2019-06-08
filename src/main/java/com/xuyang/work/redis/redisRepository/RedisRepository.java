package com.xuyang.work.redis.redisRepository;

import com.xuyang.work.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xuy
 * @Date: 2019/4/20 04:36
 * @Description:
 */
@Slf4j
@Component
public class RedisRepository {

    private static RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        RedisRepository.redisService = redisService;
    }

    /**
     * key-value关系存储
     * @param key
     * @param value
     */
    public static void insertStringRedis(String key, String value){
        log.debug("存储key-value关系");
        redisService.set(key, value);
    }

    /**
     * 将key-map存储到redis中
     * @param key
     * @param item
     * @param value
     */
    public static void insertMapRedis(String key, String item, Object value){
        log.debug("存储key-map关系");
        redisService.hset(key, item, value);
    }

    /**
     * 将key-map存储到redis中
     * @param key
     */
    public static Map<Object, Object> mapRedis(String key){
        log.debug("存储list长度");
        Map<Object, Object> map = redisService.hmget(key);
        return map;
    }

    /**
     * 将key-map存储到redis中
     * @param key
     */
    public static void createListRedis(String key){
        log.debug("初始化创建一个list");
        //list需要先创建一个list对象
        List<Object> list = new ArrayList<>();
        list.add("测试数据，不需要在一");
        redisService.lSet(key, list);
    }


    /**
     * 将key-map存储到redis中
     * @param key
     * @param value
     */
    public static void insertListRedis(String key, Object value){
        log.debug("存储key-list关系");
        redisService.lSet(key, value);
    }

    /**
     * 将key-map存储到redis中
     * @param key
     */
    public static long listRedisSize(String key){
        log.debug("获取list长度");
        long size = redisService.lGetListSize(key);
        return size;
    }
}
