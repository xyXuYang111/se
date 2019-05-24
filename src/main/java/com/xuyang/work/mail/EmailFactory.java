package com.xuyang.work.mail;

import com.xuyang.work.mail.impl.EmailFor1;
import com.xuyang.work.mail.impl.EmailFor2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailFactory {

    @Autowired
    private EmailFor1 emailFor1;

    @Autowired
    private EmailFor2 emailFor2;

    public AbstractObject abstractObject(String emailType){
        if(emailType.equals(EmailDef.EMAIL_1)){
            AbstractObject abstractObject = emailFor1;
            return abstractObject;
        }else if(emailType.equals(EmailDef.EMAIL_2)){
            AbstractObject abstractObject = emailFor2;
            return abstractObject;
        } else{
            return null;
        }
    }
}
