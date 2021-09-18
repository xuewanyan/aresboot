package com.cn.action;

import com.cn.config.ObjListenerConfig;
import com.cn.vo.CustInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * callable接口实现异步
 *
 * @author xy
 * @date 2021-8-3
 */
@RestController
@RequestMapping("action/*")
@Slf4j
public class CallableAction {

    /**
     * 注入线程池
     */
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ObjListenerConfig objListenerConfig;

    @PostMapping("callable")
    public Object echo(String msg) throws Exception {
        log.info("[外部线程 = {}]", Thread.currentThread().getName());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("内部线程：{}", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                return msg;
            }
        };
        WebAsyncTask webAsyncTask = new WebAsyncTask(200,callable);
        webAsyncTask.onTimeout(()->{
            log.info("超时线程 = [{}]",Thread.currentThread().getName());
            return "[ERROR]" + msg;
        });

        return webAsyncTask;
    }

    @PostMapping("runnable")
    public Object echo2(String msg){
        log.info("[外部线程 = {}]", Thread.currentThread().getName());
        HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.
                getRequestAttributes()).getRequest();
        DeferredResult<String> result = new DeferredResult<>(6000L);
        result.onTimeout(()->{ // 超时处理
            log.info("超时线程：{}",Thread.currentThread().getName());
            result.setResult("请求超时：" + request.getRequestURI());
        });
        result.onCompletion(()->{
            log.info("完成线程：{}",Thread.currentThread().getName());
        });
        this.threadPoolTaskExecutor.execute(()->{ // 线程核心任务
            log.info("内部线程：{}",Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.setResult("ECHO" + msg);
        });
        return result;
    }

    @PostMapping("yibu")
    public void echo3(){
        this.objListenerConfig.addListener(new CustInfo());
        log.info("正常返回=======================mi223xed");
    }
}
