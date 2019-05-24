package com.xuyang.work.message;

import com.xuyang.work.common.EmailUtil;
import com.xuyang.work.message.model.Message;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

public abstract class AbstractObject implements MessageOperate {

    protected Message email;

    protected MimeMessage message;

    protected String password;

    protected Properties properties;

    protected MimeBodyPart mimeBodyPart;

    protected Map<String, Object> emailMap;

    public void setEmail(Message email) {
        this.email = email;
    }

    @Override
    public MimeMessage sendUserName()  throws Exception{
        return message;
    }

    @Override
    public String password() throws Exception {
        return password;
    }

    @Override
    public Properties emailMay() throws Exception {
        return properties;
    }

    @Override
    public Map<String, Object> emailMap() throws Exception {
        return emailMap;
    }

    @Override
    public void sendEmail() throws Exception {

    }

    @Override
    public MimeBodyPart sendEmailPhoto()  throws Exception{
        return mimeBodyPart;
    }

    @Override
    public void sendEmailFile()  throws Exception{

    }
}