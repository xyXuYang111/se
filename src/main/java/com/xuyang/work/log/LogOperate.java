package com.xuyang.work.log;

/**
 * 日志方法
 */
public interface LogOperate {

    /**
     * 日志记录到数据库
     */
    public void writeInMysql();

    /**
     * 日志记录到redis
     */
    public void writeInRedis();

    /**
     * 日志记录到缓存中
     */
    public void writeInEcache();

    /**
     * mysql同步到redis
     */
    public void mysqlInRedis();

    /**
     * redis同步到redis
     */
    public void redisInMysql();
}
