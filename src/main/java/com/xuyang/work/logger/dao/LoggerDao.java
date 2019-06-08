package com.xuyang.work.logger.dao;

import com.xuyang.work.annotation.MyBatisDao;
import com.xuyang.work.logger.model.Logger;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface LoggerDao {

    /**
     * 添加缓存
     * @param logger
     * @return
     * @throws Exception
     */
    public int insertLogger(@Param("logger") Logger logger) throws Exception;

    /**
     * 添加日志
     * @param logger
     * @return
     * @throws Exception
     */
    public List<Logger> loggerList(@Param("logger") Logger logger) throws Exception;

    /**
     * 修改缓存
     * @param logger
     * @throws Exception
     */
    public void updateLogger(@Param(("logger"))Logger logger) throws Exception;
}
