package com.xuyang.work.mail;

import com.xuyang.work.common.EmailUtil;
import com.xuyang.work.mail.model.Email;

import java.util.Map;

public abstract class AbstractObject implements EmailOperate{

    protected Email email;

    protected String userName;

    protected String password;

    protected String emailMay;

    protected Map<String, Object> emailMap;

    public void setEmail(Email email) {
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
        if(emailMay.equals(EmailDef.EMAIL_QQ)){
            email.setReceiveNumber(EmailDef.USER_NAME_QQ);
            email.setReceivePassword(EmailDef.USER_PASSWORD_QQ);
            email.setSendNumber(userName);
            try {
                EmailUtil.sendEmailQq(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(emailMay.equals(EmailDef.EMAIL_163)){
            email.setReceiveNumber(EmailDef.USER_NAME_163);
            email.setReceivePassword(EmailDef.USER_PASSWORD_163);
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
}