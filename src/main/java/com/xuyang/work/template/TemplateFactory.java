package com.xuyang.work.template;

import com.xuyang.work.template.impl.TemplateFor1;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class TemplateFactory {

    @Autowired
    private TemplateFor1 templateFor1;

    public AbstractObject abstractObject(String templateType){
        if(templateType.equals(TemplateDef.TEMPLATE_1)){
            AbstractObject abstractObject = templateFor1;
            return abstractObject;
        }else{
            return null;
        }
    }
}
