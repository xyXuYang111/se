package com.xuyang.work.email.template;

import com.xuyang.work.email.template.model.TemplateModel;

import java.util.Map;

/**
 * 抽象方法工厂
 */
public abstract class AbstractObject implements TemplateOperate{

    private TemplateModel templateModel;

    /**
     * 定义模板参数
     * @param templateModel
     */
    public void setTemplateModel(TemplateModel templateModel) {
        this.templateModel = templateModel;
    }

    @Override
    public String templateWay() {
        return null;
    }

    @Override
    public String templateUrl() {
        return null;
    }

    @Override
    public Map<String, Object> templateMap() {
        return null;
    }

    @Override
    public void createTemplate() {

    }
}
