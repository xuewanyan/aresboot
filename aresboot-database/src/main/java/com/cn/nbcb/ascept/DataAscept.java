package com.cn.nbcb.ascept;

import com.cn.nbcb.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xy
 * @date 2021-9-4
 */
@Component
@Aspect
@Slf4j
@Order(-100)
public class DataAscept {

    @Before("execution(* com.cn.nbcb.dao.mmp..*.*(..))")
    public void switchMmpdataSourceAscept(){
        DynamicDataSource.setDateSource(DynamicDataSource.DataSourceName.MMP_NAME);
        this.log.info("切换mmp数据源");
    }
    @Before("execution(* com.cn.nbcb.dao.mmc..*.*(..))")
    public void switchMmcdataSourceAscept(){
        DynamicDataSource.setDateSource(DynamicDataSource.DataSourceName.MMC_NAME);
        this.log.info("切换mmc数据源");
    }
}
