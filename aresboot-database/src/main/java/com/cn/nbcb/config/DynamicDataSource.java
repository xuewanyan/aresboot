package com.cn.nbcb.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 数据源动态切换
 * @author xy
 * @date 2021-9-4
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    // 每次请求都需要使用自己的数据源,存储自己线程要使用的数据源
    private static final ThreadLocal<String> STRING_THREAD_LOCAL = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public interface DataSourceName{
        String MMP_NAME = "mmp";
        String MMC_NAME = "mmc";
    }

    /**
     *
     * @param defaultDataSource 默认的数据源
     * @param targetDataSource 全部的数数据源对象
     */
    public DynamicDataSource(DataSource defaultDataSource, Map<Object,Object> targetDataSource){
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet(); // 属性设置
    }

    /**
     * 设置线程
     * @param dateSourceName
     */
    public static void setDateSource(String dateSourceName){
        STRING_THREAD_LOCAL.set(dateSourceName);
    }

    /**
     * 获取线程
     * @return
     */
    public static String getDataSource(){
      return  STRING_THREAD_LOCAL.get();
    }

    /**
     * 清除
     */
    public static void clear(){
        STRING_THREAD_LOCAL.remove();
    }

    @Override
    public String toString() {
        return "this.dataSource" + getDataSource();
    }
}
