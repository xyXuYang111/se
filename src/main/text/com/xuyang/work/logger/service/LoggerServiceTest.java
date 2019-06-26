package com.xuyang.work.logger.service;

import com.xuyang.work.logger.model.Logger;
import com.xuyang.work.redis.redisRepository.RedisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class LoggerServiceTest {

    @Autowired
    private LoggerService loggerService;

    @Test
    public void loggerList() {
        //数据写道redis，在转到mysql中
        for(int i=1; i<10; i++) {
            Logger logger = new Logger();
            logger.setLogName("日志名：" + i);
            try {
                //添加数据到redis中
                RedisRepository.insertMapRedis("3", String.valueOf(i), logger.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("日志添加介绍");
    }

    @Test
    public void mapList(){
        for(int i=1; i<10; i++) {
            Logger logger = new Logger();
            logger.setLogName("日志名：" + i);
            try {
                //添加数据到redis中
                Map<Object, Object> map = RedisRepository.mapRedis("3");
                System.out.println(map.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("日志添加介绍");

        //获取list长度
        long size = RedisRepository.listRedisSize("3");
        System.out.println(size);
    }

    @Test
    public void insertLogger() {
        for(int i=1; i<10; i++) {
            Logger logger = new Logger();
            logger.setLogName("日志名：" + i);
            try {
                loggerService.insertLogger(logger);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("日志添加介绍");
    }

    @Test
    public void insertList(){
        //获取list长度
        long size = RedisRepository.listRedisSize("12");
        System.out.println(size);
        RedisRepository.createListRedis("12");
        for(int i=1; i<10; i++) {
            Logger logger = new Logger();
            logger.setLogName("日志名：" + i);
            try {
                //添加数据到redis中
                RedisRepository.insertListRedis("12", logger.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("日志添加介绍");

        long sizeEnd = RedisRepository.listRedisSize("12");
        System.out.println(sizeEnd);
    }
}
