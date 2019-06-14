package com.xuyang.work.controller;

import com.xuyang.work.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class SessionController {

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping(value = "sessionText", method = RequestMethod.GET)
    public String sessionController(HttpSession session){
        log.debug("存储session到redis中");
        String value = String.valueOf(System.currentTimeMillis());
        log.debug(value);
        session.setAttribute("KEY", value);
        redisService.set("KEY", value, 1*60);
        String result = (String) session.getAttribute("KEY");
        log.debug("session:" + result);
        String redisResult = (String) redisService.get("KEY");
        log.debug("redis: " + redisResult);
        return "测试spring-session";
    }

    @ResponseBody
    @RequestMapping(value = "defaultSessionController", method = RequestMethod.GET)
    public String defaultSessionController(HttpSession session){
        log.debug("不同服务器获取session，判断是存在浏览器上还是cookie上");
        String result = (String) session.getAttribute("KEY");
        log.debug(result);
        return "测试spring-session";
    }

    @ResponseBody
    @RequestMapping(value = "redisSessionController", method = RequestMethod.GET)
    public String redisSessionController(HttpSession session){
        log.debug("自己做redis实现session缓存");
        String redisResult = (String) redisService.get("KEY");
        log.debug("redis: " + redisResult);
        return "测试spring-session";
    }


}
