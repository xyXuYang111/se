package com.xuyang.work.email.mail.task;

import com.xuyang.work.email.mail.model.Email;
import com.xuyang.work.email.mail.util.EmailQq;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class EmailTesk {

    /**
     * 定时调度：体能锻炼
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void email1(){
        log.debug("定时调度1");
        Email email = new Email();
        email.setTitleName("体能训练提醒");
        email.setMessage("请进行体能训练，你已经太胖了");
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

    /**
     * 定时调度：不要暴饮暴食
     */
    @Scheduled(cron = "0 0 8,12,18 * * ?")
    public void email2(){
        log.debug("定时调度2");
        Email email = new Email();
        email.setTitleName("你太胖了");
        email.setMessage("少吃点，不想成为一个胖子少吃点，你太胖了");
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
