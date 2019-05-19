package com.xuyang.work.email.template;

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

    /**
     * 获取模板的参数
     * @return
     */
    public Map<String, Object> templateMap();

    /**
     * 生成模板
     */
    public void createTemplate();
}
