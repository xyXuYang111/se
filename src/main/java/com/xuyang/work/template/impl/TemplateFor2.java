package com.xuyang.work.template.impl;

import com.xuyang.work.common.DateUtil;
import com.xuyang.work.template.AbstractObject;
import com.xuyang.work.template.TemplateDef;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 荣誉文件模板
 */
@Slf4j
@Component
public class TemplateFor2 extends AbstractObject {

    @Autowired
    private DateUtil dateUtil;

    @Override
    public String templateWay() {
        log.info("文件生成方式");
        return TemplateDef.TEMPLATE_WAY;
    }

    @Override
    public String templateUrl() {
        log.info("文件模板路径");
        return TemplateDef.TEMPLATE_URL_2;
    }

    @Override
    public String fileName() {
        log.info("生成文件路径");
        StringBuilder fileName = new StringBuilder();
        fileName.append("D:\\file\\template2\\");
        fileName.append(System.currentTimeMillis()).append(".docx");
        return fileName.toString();
    }

    @Override
    public Map<String, Object> templateMap() {
        log.info("模板参数");
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("userName", "许洋");
        objectMap.put("appellation", templateModelInfo.getTemplateAppellation());
        objectMap.put("num", templateModelInfo.getTemplateNum());
        objectMap.put("context", templateModelInfo.getTemplateContext());
        objectMap.put("time", dateUtil.nowYear());
        return objectMap;
    }

    @Override
    public void createTemplate() {
        log.info("生成模板");
        super.createTemplate();
    }
}
