package com.xuyang.work.message;

import com.xuyang.work.message.impl.MessageFor1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageFactory {

    @Autowired
    private MessageFor1 emailFor1;

    public AbstractObject abstractObject(String emailType){
        if(emailType.equals(MessageDef.EMAIL_1)){
            AbstractObject abstractObject = emailFor1;
            return abstractObject;
        } else{
            return null;
        }
    }
}
