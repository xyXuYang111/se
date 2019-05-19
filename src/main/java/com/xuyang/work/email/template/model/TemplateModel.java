package com.xuyang.work.email.template.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
    private String templateName;

    private String templateContext;

    private Object templateObject;
}
