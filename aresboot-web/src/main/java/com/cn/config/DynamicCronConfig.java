package com.cn.config;

import com.cn.task.AppSchedule;
import com.cn.task.DynamicCronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author xy
 * @date 2021-7-27
 */
public class DynamicCronConfig implements SchedulingConfigurer {

    @Autowired
    private DynamicCronExpression dynamicCronExpression;

    @Autowired
    private AppSchedule appSchedule;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(()-> appSchedule.sendlockTask(),
                triggerContext -> {
            String cron = this.dynamicCronExpression.getCron();
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
        });
    }
}
