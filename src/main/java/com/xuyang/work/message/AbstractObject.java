package com.xuyang.work.message;

import com.xuyang.work.common.EmailUtil;
import com.xuyang.work.message.model.Message;

import java.util.Map;

public abstract class AbstractObject implements MessageOperate {

    protected Message email;

    protected String userName;

    protected String password;

    protected String emailMay;

    protected Map<String, Object> emailMap;

    public void setEmail(Message email) {
        this.email = email;
    }

    @Override
    public String userName() {
        return userName;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String emailMay() {
        return emailMay;
    }

    @Override
    public Map<String, Object> emailMap() {
        return emailMap;
    }

    @Override
    public void sendEmail() {
        String userName = userName();
        String password = password();
        String emailMay = emailMay();
        //qq的邮件方式
        if(emailMay.equals(MessageDef.EMAIL_QQ)){
            email.setReceiveNumber(MessageDef.USER_NAME_QQ);
            email.setReceivePassword(MessageDef.USER_PASSWORD_QQ);
            email.setSendNumber(userName);
            try {
                EmailUtil.sendEmailQq(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(emailMay.equals(MessageDef.EMAIL_163)){
            email.setReceiveNumber(MessageDef.USER_NAME_163);
            email.setReceivePassword(MessageDef.USER_PASSWORD_163);
            email.setSendNumber(userName);
            email.setSendPassword(password);
            try {
                EmailUtil.sendMail(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //另外一种方式发送邮件
        }
    }

    @Override
    public void sendEmailPhoto() {

    }

    @Override
    public void sendEmailFile() {

    }
}