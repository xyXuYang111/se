package com.xuyang.work.message.impl;

import com.xuyang.work.message.AbstractObject;
import com.xuyang.work.message.MessageDef;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageFor2 extends AbstractObject {

    @Override
    public String userName() {
        return "15172399690@qq.com";
    }

    @Override
    public String emailMay() {
        return MessageDef.EMAIL_QQ;
    }

    @Override
    public Map<String, Object> emailMap() {
        return super.emailMap();
    }

    @Override
    public void sendEmail() {
        super.sendEmail();
    }
}
