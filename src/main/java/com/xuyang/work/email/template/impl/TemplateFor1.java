package com.xuyang.work.email.template.impl;

import com.xuyang.work.email.template.AbstractObject;
import com.xuyang.work.email.template.model.TemplateModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
        return "";
    }

    @Override
    public String templateUrl() {
        return super.templateUrl();
    }

    @Override
    public Map<String, Object> templateMap() {
        return super.templateMap();
    }

    @Override
    public void createTemplate() {
        super.createTemplate();
    }
}
