package com.cn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
@Slf4j
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        log.info("错误捕获注册===========================================================================");
        // 定义404错误页
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND,"/errors/error_404");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/errors/error_500");
        registry.addErrorPages(errorPage404,errorPage500);
    }
}
