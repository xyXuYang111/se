package com.xuyang.work.logger.service;

import com.xuyang.work.logger.dao.LoggerDao;
import com.xuyang.work.logger.model.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class LoggerService {

    @Autowired
    private LoggerDao loggerDao;

    public List<Logger> loggerList(Logger logger) throws Exception{
        log.debug("获取日志记录");
        return loggerDao.loggerList(logger);
    }

    public int insertLogger(Logger logger) throws Exception{
        log.debug("添加日志记录");
        return loggerDao.insertLogger(logger);
    }
}
