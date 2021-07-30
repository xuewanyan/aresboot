package com.cn.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xy
 * @date 2021-7-27
 */
@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S") //30S 自动回收锁，防止阻塞
public class ShedLockRedisConfig {

    @Value("${spring.profiles.active}")
    private String evn;

    @Bean
    public LockProvider lockProvider(RedisConnectionFactory connectionFactory){
        return new RedisLockProvider(connectionFactory,this.evn);
    }
}
