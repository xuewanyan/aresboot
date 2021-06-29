package com.cn.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 售票，同步处理
 */
@Data
@AllArgsConstructor
@Slf4j
public class SaleTicket {

    private int ticket;

    @SneakyThrows
    @Synchronized
    public void sale(){
        while (this.ticket > 0){
            if(this.ticket > 0){
               Thread.sleep(1000);
               log.info("["+Thread.currentThread().getName() +"]售票，ticket=" + ticket--);
            }
        }

    }

    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket(11);
        for (int i = 0;i<10;i++){
            new Thread(()->{
                saleTicket.sale();
            },"==="+i).start();

        }
    }
}
