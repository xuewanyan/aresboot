package com.cn.nbcb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;

/**
 * @author xy
 * @date 2021-9-15
 */
@Configuration
public class SerurityConfig extends WebSecurityConfigurerAdapter {

    private final static String PASSWORD = "";

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admind").password(PASSWORD).roles("USER","ADMIN");
        auth.inMemoryAuthentication().withUser("admind").password(PASSWORD).roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers().hasRole().antMatchers().hasRole()
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(new HashMap<>());
    }
}
