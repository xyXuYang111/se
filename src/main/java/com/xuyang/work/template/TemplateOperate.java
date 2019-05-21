package com.xuyang.work.template;

import com.xuyang.work.template.model.TemplateModel;

import java.util.Map;

/**
 * 模板的通用方法
 */
public interface TemplateOperate {

    public String templateWay();

    /**
     * 获取模板路径
     * @return
     */
    public String templateUrl();

    public String fileName();

    /**
     * 获取模板的参数
     * @return
     */
    public Map<String, Object> templateMap(TemplateModel templateModelInfo);

    /**
     * 生成模板
     */
    public void createTemplate(TemplateModel templateModel);
}
