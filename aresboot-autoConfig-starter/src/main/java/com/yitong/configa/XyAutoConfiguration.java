package com.yitong.configa;

import com.yitong.voa.Detp;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xy
 * @date 2021-8-9
 */
@Configuration
@EnableConfigurationProperties(Detp.class)
//@Import(Detp.class)
//@Import(DefaultSelectorImport.class)
//@Import(DefaultRegistBean.class)
public class XyAutoConfiguration {

    @Bean(name = "books")
    public List<String> getBookList(){
        List<String> list = new ArrayList<>();
        list.add("boot1");
        list.add("boot2");
        list.add("boot3");
        list.add("boot4");
        list.add("boot5");
        return list;
    }
}
