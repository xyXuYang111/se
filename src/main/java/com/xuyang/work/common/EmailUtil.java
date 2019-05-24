package com.xuyang.work.common;

import com.sun.mail.util.MailSSLSocketFactory;
import com.xuyang.work.message.MessageDef;
import com.xuyang.work.message.model.Message;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailUtil {

    public static boolean sendMail(Message email) throws Exception {
        // 定义Properties对象,设置环境信息
        Properties props = new Properties();
        //设置邮件服务器的地址
        props.setProperty("message.smtp.host", "smtp.163.com");
        // 指定的smtp服务器
        props.setProperty("message.smtp.auth", "true");
        //设置发送邮件使用的协议
        props.setProperty("message.transport.protocol", "smtp");
        // 创建Session对象,session对象表示整个邮件的环境信息
        Session session = Session.getInstance(props);
        //设置输出调试信息
        session.setDebug(true);
        //Message的实例对象表示一封电子邮件
        MimeMessage message = new MimeMessage(session);
        //设置发件人的地址
        message.setFrom(new InternetAddress(email.getSendNumber()));
        //设置主题
        message.setSubject(email.getTitleName());
        //设置邮件的文本内容
        message.setText(email.getTitleName());
        message.setContent(email.getMessage(), "text/html;charset=utf-8");            //从session的环境中获取发送邮件的对象
        Transport transport = session.getTransport();
        //连接邮件服务器
        transport.connect("smtp.163.com", 25, email.getSendNumber(), email.getSendPassword());
        //设置收件人地址,并发送消息
        transport.sendMessage(message, new Address[]{new InternetAddress(email.getReceiveNumber())});
        transport.close();
        return true;
    }

    public static boolean sendEmailQq(Message email) throws Exception {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("message.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("message.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("message.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("message.transport.protocol", "smtp");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("message.smtp.ssl.enable", "true");
        props.put("message.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        javax.mail.Message msg = new MimeMessage(session);
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

    public static void sendEmail(Properties properties, Message email)throws Exception{

        /*
         * 在 JavaMail 中，可以通过 extends Authenticator 抽象类，在子类中覆盖父类中的
         * getPasswordAuthentication() 方法，就可以实现以不同的方式来进行登录邮箱时的用户身份认证。JavaMail
         * 中的这种设计是使用了策略模式（Strategy
         */
        MimeMessage message = new MimeMessage(Session.getInstance(properties,
                new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(//设置发送帐号密码
                                MessageDef.USER_NAME_163, MessageDef.USER_PASSWORD_163);
                    }
                }));
        // 设置邮件的属性
        // 设置邮件的发件人
        message.setFrom(new InternetAddress(MessageDef.USER_NAME_163));
        // 设置邮件的收件人 cc表示抄送 bcc 表示暗送
        message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(
                MessageDef.USER_NAME_163));
        // 设置邮件的主题
        message.setSubject("系统自动发送邮件");
        // 创建邮件的正文
        MimeBodyPart text = new MimeBodyPart();
        // setContent(“邮件的正文内容”,”设置邮件内容的编码方式”)
        text.setContent("此邮件为系统自动发送<img src='cid:a'><img src='cid:b'>",
                "text/html;charset=gb2312");

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

        MimeBodyPart img2 = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource("D:\\photo\\1111.jpg"));//第二张图片路径
        img2.setDataHandler(dh2);
        img2.setContentID("b");

        // 创建附件
        MimeBodyPart attch = new MimeBodyPart();
        DataHandler dh1 = new DataHandler(new FileDataSource("D:\\file\\template2\\1558625845769.doc"));
        attch.setDataHandler(dh1);
        String filename1 = dh1.getName();
        //MimeUtility 是一个工具类，encodeText（）用于处理附件字，防止中文乱码问题
        attch.setFileName(MimeUtility.encodeText(filename1));

        // 关系 正文和图片的
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(img);
        mm.setSubType("related");// 设置正文与图片之间的关系
        // 图班与正文的 body
        MimeBodyPart all = new MimeBodyPart();
        all.setContent(mm);
        // 附件与正文（text 和 img）的关系
        MimeMultipart mm2 = new MimeMultipart();
        mm2.addBodyPart(all);
        mm2.addBodyPart(img2);
        mm2.addBodyPart(attch);
        mm2.setSubType("mixed");// 设置正文与附件之间的关系

        message.setContent(mm2);
        message.saveChanges(); // 保存修改

        Transport.send(message);// 发送邮件
        System.out.println("邮件发送成功");
    }
}
