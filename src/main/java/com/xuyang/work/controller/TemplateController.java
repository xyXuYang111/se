package com.xuyang.work.controller;

import com.xuyang.work.template.AbstractObject;
import com.xuyang.work.template.TemplateFactory;
import com.xuyang.work.template.model.TemplateModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Data
@Slf4j
@Controller
public class TemplateController {

    @Autowired
    private TemplateFactory templateFactory;

    @ResponseBody
    @RequestMapping(value = "createController", method = RequestMethod.POST)
    public String createController(@RequestBody TemplateModel templateModel){
        log.info("生成模板");
        AbstractObject abstractObject = templateFactory.abstractObject(templateModel.getTemplateType());
        abstractObject.setTemplateModelInfo(templateModel);
        abstractObject.createTemplate();
        return "模板文件生成成功";
    }
}
