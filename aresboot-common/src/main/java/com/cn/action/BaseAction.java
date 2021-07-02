package com.cn.action;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * xueyan
 */
public abstract class BaseAction {
    private static final DateTimeFormatter LOCAL_DATE_FORMATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(java.util.Date.class,new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                LocalDate localDate = LocalDate.parse(text,LOCAL_DATE_FORMATE);
                Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
                super.setValue(java.util.Date.from(instant));
            }
        });
    }
}
