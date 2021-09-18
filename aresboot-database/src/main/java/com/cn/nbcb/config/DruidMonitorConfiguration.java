package com.cn.nbcb.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author xy
 * @date 2021-8-25
 */
@Configuration
public class DruidMonitorConfiguration {

    @Bean("druidStatViewServlet")
    public ServletRegistrationBean<StatViewServlet> getDruidStatViewServlet(){
        ServletRegistrationBean<StatViewServlet> registrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_ALLOW,"127.0.0.1");
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_DENY,"");
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_USERNAME,"admin");
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_PASSWORD,"111111");
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_RESET_ENABLE,"true");
        return registrationBean;
    }

    @Bean("sqlStatFilter")
    public StatFilter getStatFilter(){
//        StatFilter filter = new StatFilter();
//        filter.setMergeSql();
//        filter.setLogSlowSql(true);
//        filter.setSlowSqlMillis(2000);
        return new StatFilter();
    }
}
