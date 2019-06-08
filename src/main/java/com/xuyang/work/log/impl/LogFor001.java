package com.xuyang.work.log.impl;

import com.xuyang.work.log.AbstractObject;
import com.xuyang.work.log.LogDef;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 文本缓存
 */
@Component
@Slf4j
public class LogFor001 extends AbstractObject {
    @Override
    public String redisKey() {
        log.info("生成redis的key");
        String fileId = logModel.getLogId();
        StringBuilder redisBuilder = new StringBuilder();
        redisBuilder.append(LogDef.REDIS_KEY_1).append(fileId);
        return redisBuilder.toString();
    }

    @Override
    public String ecacheName() {
        log.info("生成缓存的key");
        String fileId = logModel.getLogId();
        StringBuilder ecacheBuilder = new StringBuilder();
        ecacheBuilder.append(LogDef.ECACHE_KEY_1).append(fileId);
        return ecacheBuilder.toString();
    }

    @Override
    public void writeInMysql() {
        super.writeInMysql();
    }

    @Override
    public void writeInRedis() {
        super.writeInRedis();
    }

    @Override
    public void writeInEcache() {
        super.writeInEcache();
    }

    @Override
    public void mysqlInRedis() {
        super.mysqlInRedis();
    }

    @Override
    public void redisInMysql() {
        super.redisInMysql();
    }
}
