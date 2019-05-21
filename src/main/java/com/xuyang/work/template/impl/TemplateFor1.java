package com.xuyang.work.template.impl;

import com.xuyang.work.template.AbstractObject;
import com.xuyang.work.template.TemplateDef;
import com.xuyang.work.template.model.TemplateModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 日记模板
 */
@Data
@Slf4j
@Component
public class TemplateFor1 extends AbstractObject {

    @Override
    public String templateWay() {
        log.info("文件生成方式");
        return TemplateDef.TEMPLATE_WAY;
    }

    @Override
    public String templateUrl() {
        log.info("文件模板路径");
        return TemplateDef.TEMPLATE_URL_1;
    }

    @Override
    public String fileName() {
        log.info("生成文件路径");
        StringBuilder fileName = new StringBuilder();
        fileName.append("D:\\file\\template1\\");
        fileName.append(System.currentTimeMillis()).append(".doc");
        return fileName.toString();
    }

    @Override
    public Map<String, Object> templateMap(TemplateModel templateModelInfo) {
        log.info("模板参数");
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("userName", "许洋");
        objectMap.put("daily", templateModelInfo.getTemplateContext());
        objectMap.put("nowTime", "2019/5/22 0:30");
        return objectMap;
    }

    @Override
    public void createTemplate(TemplateModel templateModel) {
        log.info("生成模板");
        super.createTemplate(templateModel);
    }
}
