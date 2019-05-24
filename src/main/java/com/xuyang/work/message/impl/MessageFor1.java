package com.xuyang.work.message.impl;

import com.xuyang.work.message.AbstractObject;
import com.xuyang.work.message.MessageDef;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

/**
 * 发消息：文本消息，可以涉及图片，文本
 */
@Slf4j
@Component
public class MessageFor1 extends AbstractObject {

    @Override
    public MimeMessage sendUserName() throws Exception{
        log.info("邮件发送人和接收人");
        //邮件发送人
        MimeMessage message = new MimeMessage(Session.getInstance(properties,
                new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(//设置发送帐号密码
                                MessageDef.USER_NAME_163, MessageDef.USER_PASSWORD_163);
                    }
                }));
        // 设置邮件的收件人
        message.setFrom(new InternetAddress(MessageDef.USER_NAME_163));
        // 设置邮件的收件人 cc表示抄送 bcc 表示暗送
        message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(
                MessageDef.USER_NAME_163));
        // 设置邮件的主题
        message.setSubject("图片收集邮件");
        return message;
    }

    @Override
    public String password() {
        return "xy1234qwer";
    }

    /**
     * 短信发送方式
     * @return
     */
    @Override
    public Properties emailMay() {
        //定义前缀
        Properties properties = new Properties();
        //设置邮件服务器的地址
        properties.setProperty("message.smtp.host", "smtp.163.com");
        // 指定的smtp服务器
        properties.setProperty("message.smtp.auth", "true");
        //设置发送邮件使用的协议
        properties.setProperty("message.transport.protocol", "smtp");
        return properties;
    }

    @Override
    public Map<String, Object> emailMap()  throws Exception{
        return super.emailMap();
    }

    @Override
    public void sendEmail()  throws Exception{
        log.info("创建邮件正文");
        // 创建邮件的正文
        MimeBodyPart text = new MimeBodyPart();
        // setContent(“邮件的正文内容”,”设置邮件内容的编码方式”)
        text.setContent("采集图片如下：<img src='cid:a'>，请妥善保管这些图片",
                "text/html;charset=gb2312");
        super.sendEmail();
    }

    @Override
    public MimeBodyPart sendEmailPhoto()  throws Exception{

        //发送图片：此图片需要本地是存在的
        // 创建图片
        MimeBodyPart img = new MimeBodyPart();
        /*
         * JavaMail API不限制信息只为文本,任何形式的信息都可能作茧自缚MimeMessage的一部分.
         * 除了文本信息,作为文件附件包含在电子邮件信息的一部分是很普遍的. JavaMail
         * API通过使用DataHandler对象,提供一个允许我们包含非文本BodyPart对象的简便方法.
         */
        DataHandler dh = new DataHandler(new FileDataSource("D:\\photo\\1111.jpg"));//图片路径
        img.setDataHandler(dh);
        // 创建图片的一个表示用于显示在邮件中显示
        img.setContentID("a");
        return img;
    }

    @Override
    public void sendEmailFile()  throws Exception{
        //发送文件附件：此文本需要本地存在的
        super.sendEmailFile();
    }
}
