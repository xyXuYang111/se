package com.xuyang.work.message;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

public interface MessageOperate {

    /**
     * 邮件发送人
     * @return
     */
    public MimeMessage sendUserName()  throws Exception;

    /**
     * 邮件接收人
     * @return
     */
    public String password() throws Exception;

    /**
     * 发送方式
     * @return
     */
    public Properties emailMay() throws Exception;

    /**
     * email参数
     * @return
     */
    public Map<String, Object> emailMap() throws Exception;

    /**
     * 发送短信：文本
     */
    public void sendEmail() throws Exception;

    /**
     * 发送邮件：图片
     */
    public MimeBodyPart sendEmailPhoto() throws Exception;

    /**
     * 发送邮件：文件
     */
    public void sendEmailFile() throws Exception;
}
