package com.cn.nbcb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xy
 * @date 2021-9-4
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean("dataSource")
    @Primary // 注入DataSource实例的时候优先考虑
    @DependsOn({"mmpDataSource","mmcDataSource"})
    public DynamicDataSource getDataSource(DataSource mmpDataSource,DataSource mmcDataSource){
        Map<Object,Object> map = new HashMap(5);
        map.put(DynamicDataSource.DataSourceName.MMC_NAME,mmcDataSource);
        map.put(DynamicDataSource.DataSourceName.MMP_NAME,mmpDataSource);
        return new DynamicDataSource(mmpDataSource,map);
    }
}
