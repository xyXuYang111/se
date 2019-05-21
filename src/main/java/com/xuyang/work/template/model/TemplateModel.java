package com.xuyang.work.template.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 模板参数
 */
@Data
@Slf4j
@ToString
public class TemplateModel implements Serializable {

    private static final long serialVersionUID = -230961847659354568L;
    /**
     * 模板生成名称
     */
    @JsonProperty(value = "templateType")
    private String templateType;

    @JsonProperty(value = "templateContext")
    private String templateContext;

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTemplateContext() {
        return templateContext;
    }

    public void setTemplateContext(String templateContext) {
        this.templateContext = templateContext;
    }
}
