package com.xuyang.work.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Slf4j
public class DateUtil {

    public String nowDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(df.format(System.currentTimeMillis()));
        return df.format(System.currentTimeMillis());
    }

    public String nowYear(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        log.info(df.format(System.currentTimeMillis()));
        return df.format(System.currentTimeMillis());
    }
}
