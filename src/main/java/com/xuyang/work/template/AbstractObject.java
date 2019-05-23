package com.xuyang.work.template;

import com.xuyang.work.template.model.TemplateModel;

import java.util.Map;

/**
 * 抽象方法工厂
 */
public abstract class AbstractObject implements TemplateOperate{

    protected TemplateModel templateModelInfo;

    protected Map<String, Object> templateMap;

    protected String fileName;

    protected String templateName;

    public void setTemplateModelInfo(TemplateModel templateModelInfo) {
        this.templateModelInfo = templateModelInfo;
    }

    public void setTemplateMap(Map<String, Object> templateMap) {
        this.templateMap = templateMap;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String templateUrl() {
        return templateName;
    }

    @Override
    public String fileName() {
        return fileName;
    }

    @Override
    public Map<String, Object> templateMap() {
        return templateMap;
    }

    @Override
    public void createTemplate() {
        try {
            String templateName = templateUrl();
            String fileName = fileName();
            Map<String, Object> templateMap = templateMap();
            FreemarkerUtil.createDoc(templateMap, fileName, templateName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
