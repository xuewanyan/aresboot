package com.cn.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器
 */
@Slf4j
@WebListener
public class WebServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(sce.getServletContext().getContextPath());
        log.info(sce.getServletContext().getServletContextName());
    }
}
