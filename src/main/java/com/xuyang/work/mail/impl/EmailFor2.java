package com.xuyang.work.mail.impl;

import com.xuyang.work.mail.AbstractObject;
import com.xuyang.work.mail.EmailDef;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailFor2 extends AbstractObject {

    @Override
    public String userName() {
        return "15172399690@qq.com";
    }

    @Override
    public String emailMay() {
        return EmailDef.EMAIL_QQ;
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
