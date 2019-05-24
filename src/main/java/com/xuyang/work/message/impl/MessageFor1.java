package com.xuyang.work.message.impl;

import com.xuyang.work.message.AbstractObject;
import com.xuyang.work.message.MessageDef;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 发消息：文本消息，可以涉及图片，文本
 */
@Component
public class MessageFor1 extends AbstractObject {
    @Override
    public String userName() {
        return "15172399690@163.com";
    }

    @Override
    public String password() {
        return "xy1234qwer";
    }

    @Override
    public String emailMay() {
        return MessageDef.EMAIL_163;
    }

    @Override
    public Map<String, Object> emailMap() {
        return super.emailMap();
    }

    @Override
    public void sendEmail() {
        super.sendEmail();
    }

    @Override
    public void sendEmailPhoto() {
        //发送图片：此图片需要本地是存在的
        super.sendEmailPhoto();
    }

    @Override
    public void sendEmailFile() {
        super.sendEmailFile();
    }
}
