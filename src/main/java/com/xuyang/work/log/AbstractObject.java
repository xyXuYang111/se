package com.xuyang.work.log;

import com.xuyang.work.log.model.LogModel;
import com.xuyang.work.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class AbstractObject implements LogOperate{

    /**
     * 缓存对象参数
     */
    protected LogModel logModel;

    public void setLogModel(LogModel logModel) {
        this.logModel = logModel;
    }

    /**
     * redis的key
     * @return
     */
    public String redisKey(){
        return null;
    }

    /**
     * ecache的key
     * @return
     */
    public String ecacheName(){
        return null;
    }

    @Override
    public void writeInMysql() {

    }

    @Override
    public void writeInRedis() {

    }

    @Override
    public void writeInEcache() {

    }

    @Override
    public void mysqlInRedis() {

    }

    @Override
    public void redisInMysql() {

    }
}
