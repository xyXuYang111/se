package com.xuyang.work.mail;

import java.util.Map;

public interface EmailOperate {

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
     * 发送短信
     */
    public void sendEmail();
}
