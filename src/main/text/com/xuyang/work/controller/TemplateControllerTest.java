package com.xuyang.work.controller;

import com.xuyang.work.template.TemplateDef;
import com.xuyang.work.template.model.TemplateModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class TemplateControllerTest {

    String url = "http://localhost:8080/createController.do";

    @Test
    public void createController() {
        RestTemplate restTemplate = new RestTemplate();
        TemplateModel templateModel = new TemplateModel();
        templateModel.setTemplateType(TemplateDef.TEMPLATE_1);
        String result = restTemplate.postForObject(url, templateModel, String.class);
        System.out.println(result);
    }
}
