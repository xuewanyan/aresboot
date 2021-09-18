package com.cn.action;

import com.cn.xy.Watch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author xy
 * @date 2021-8-19
 */
@RestController
@RequestMapping("watch/*")
@Slf4j
public class WatchAction {

    @Autowired
    private Watch watch;

    @PostMapping("watch1")
    public void watch1() throws InterruptedException {
        this.watch.start();
        TimeUnit.SECONDS.sleep(5);
        this.watch.stop();

        log.info("开始时间【{}】,结束时间【{}】，总耗时【{}】",
                this.watch.getStartTime(),
                this.watch.getStopTime(),
                this.watch.getAllTime());
    }
    @PostMapping("watch2")
    public void watch2() throws InterruptedException {
        this.watch.start();
        TimeUnit.SECONDS.sleep(10);
        this.watch.stop();

        log.info("开始时间【{}】,结束时间【{}】，总耗时【{}】",
                this.watch.getStartTime(),
                this.watch.getStopTime(),
                this.watch.getAllTime());
    }
}
