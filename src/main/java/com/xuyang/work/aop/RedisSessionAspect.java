package com.xuyang.work.aop;

import com.xuyang.work.redis.RedisService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019-4-20 09:36
 * @Description:
 */
@Slf4j
@Component
@Aspect
public class RedisSessionAspect {

    @Autowired
    private RedisService redisService;

    //指定切入点表达式，拦截那些方法，即为那些类生成代理对象
    //@Pointcut("execution(* com.bie.aop.UserDao.save(..))")  ..代表所有参数
    //@Pointcut("execution(* com.bie.aop.UserDao.*())")  指定所有的方法
    //@Pointcut("execution(* com.bie.aop.UserDao.save())") 指定save方法

    @Pointcut("execution(* com.xuyang.work.controller.SessionController.*(..))")
    public void pointCut(){
        log.info("切点方法：刷新redis缓存");
    }

    /**
     * 参数校验
     * @param joinPoint
     */
    @Before("pointCut()")
    public void begin(JoinPoint joinPoint) {
        log.info("前置通知");
        log.debug("保证redis中的session活性:根据session失效时间进行不间断的更新");
        //通过ecache来实现下
        String result = (String) redisService.get("KEY");
        if (result != null) {
            //重新刷新
            redisService.set("KEY", result, 1 * 60);
            log.debug("redis刷新成功");
        }
    }

    /**
     * 异常抓取
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("环绕异常通知");
    }

    /**
     * 操作成功日志记录
     * @param joinPoint
     */
    @After("pointCut()")
    public void close(JoinPoint joinPoint){
        log.info("后置通知");
    }
}
