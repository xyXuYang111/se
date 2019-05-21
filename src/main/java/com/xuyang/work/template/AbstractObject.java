package com.xuyang.work.template;

import com.xuyang.work.template.model.TemplateModel;

import java.util.Map;

/**
 * 抽象方法工厂
 */
public abstract class AbstractObject implements TemplateOperate{

    protected Map<String, Object> templateMap;

    protected String fileName;

    protected String templateName;

    @Override
    public String templateUrl() {
        return templateName;
    }

    @Override
    public String fileName() {
        return fileName;
    }

    @Override
    public Map<String, Object> templateMap(TemplateModel templateModelInfo) {
        return templateMap;
    }

    @Override
    public void createTemplate(TemplateModel templateModelInfo) {
        try {
            String templateName = templateUrl();
            String fileName = fileName();
            Map<String, Object> templateMap = templateMap(templateModelInfo);
            FreemarkerUtil.createDoc(templateMap, fileName, templateName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
