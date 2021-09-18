package com.cn.nbcb.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @author xy
 * @date 2021-9-4
 */
// @Configuration
public class DruidMultDataSource {

    @Bean("mmpDataSource")
    @ConfigurationProperties("spring.datasource.mmp")
    public DataSource getMmpDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("mmcDataSource")
    @ConfigurationProperties("spring.datasource.mmc")
    public DataSource getMmcDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
