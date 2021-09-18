package com.cn.nbcb.config.mybatis;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author xy
 * @date 2021-9-7
 */
//@Configuration
public class MybatisPlusConfig {

    @Autowired
    DataSource dataSource;

    @Bean("mybatisSqlSessionFactoryBean")
    public MybatisSqlSessionFactoryBean getMybatisSqlSessionFactoryBean(){
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new FlagMateObjectHandler());
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);
        return  mybatisSqlSessionFactoryBean;
    }
}
