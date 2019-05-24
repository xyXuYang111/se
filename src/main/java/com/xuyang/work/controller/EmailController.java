package com.xuyang.work.controller;

import com.xuyang.work.message.AbstractObject;
import com.xuyang.work.message.MessageFactory;
import com.xuyang.work.message.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class EmailController {

    @Autowired
    private MessageFactory messageFactory;

    @ResponseBody
    @RequestMapping(value = "sendEmail", method = RequestMethod.POST)
    public String sendEmail(@RequestBody Message email){
        log.info("发送邮件");
        AbstractObject abstractObject = messageFactory.abstractObject(email.getEmailType());
        abstractObject.setEmail(email);
        abstractObject.sendEmail();
        return "邮件发送成功";
    }
}
