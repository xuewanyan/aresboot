package com.cn.task;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class AppSchedule {

//    @Scheduled(fixedDelay = 3000)
//    private void schedule1() throws InterruptedException {
//        log.info("schedule1==============");
//        Thread.sleep(5000);
//    }
//    @Scheduled(cron = "1/2 * * * * ?")
//    private void schedule2(){
//        log.info("schedule2==============");
//    }

    /**
     * 测试分布式
     */
    @SchedulerLock(name = "task",lockAtLeastFor = "5000")
    public void sendlockTask(){
        log.info("ShedLock定时任务，{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
