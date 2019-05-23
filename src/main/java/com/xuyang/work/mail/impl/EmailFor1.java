package com.xuyang.work.mail.impl;

import com.xuyang.work.mail.AbstractObject;
import com.xuyang.work.mail.EmailDef;
import com.xuyang.work.mail.model.Email;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailFor1 extends AbstractObject {
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
        return EmailDef.EMAIL_163;
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
