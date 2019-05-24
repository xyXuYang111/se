package com.xuyang.work.message;

import java.util.Map;

public interface MessageOperate {

    /**
     * 发送人
     * @return
     */
    public String userName();

    /**
     * 密码
     * @return
     */
    public String password();

    /**
     * 发送方式
     * @return
     */
    public String emailMay();

    /**
     * email参数
     * @return
     */
    public Map<String, Object> emailMap();

    /**
     * 发送短信：文本
     */
    public void sendEmail();

    /**
     * 发送邮件：图片
     */
    public void sendEmailPhoto();

    /**
     * 发送邮件：文件
     */
    public void sendEmailFile();
}
