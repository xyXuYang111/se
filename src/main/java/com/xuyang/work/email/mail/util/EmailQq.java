package com.xuyang.work.email.mail.util;

import com.sun.mail.util.MailSSLSocketFactory;
import com.xuyang.work.email.mail.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Auther: 许洋
 * @Date: 2019/1/6 21:39
 * @Description: qq邮箱
 */
@Slf4j
@Component
public class EmailQq {

    public boolean sendEmailQq(Email email) throws Exception {

        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        Message msg = new MimeMessage(session);
        //标题
        msg.setSubject(email.getTitleName());
        msg.setText(email.getMessage());
        msg.setFrom(new InternetAddress(email.getSendNumber()));

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", email.getReceiveNumber(), email.getReceivePassword());

        transport.sendMessage(msg, new Address[]{new InternetAddress(email.getSendNumber())});
        transport.close();
        return true;
    }

    public static void main(String[] args){
        Email email = new Email();
        email.setTitleName("qq邮件客户端开发测试");
        email.setMessage("QQ邮件测试");
        email.setSendName("许洋");
        email.setSendNumber("1824650783@qq.com");
        email.setReceiveNumber("许洋");
        email.setReceiveNumber("1824650783@qq.com");
        email.setReceivePassword("ditshyqdlloxgbfh");

        try {
            EmailQq emailQq = new EmailQq();
            emailQq.sendEmailQq(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
