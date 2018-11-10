package com.baizhi.controller;

import com.baizhi.job.MyJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * 1. 写一个静态页面 参数为 job name和group  trigger name和group cronException
 *
 * Created by wdwhwn on 2018/11/9.
 */

@RestController
public class QuartzController {
    @Autowired
    private Scheduler scheduler;
//    启动调度器
    @RequestMapping("/test")
    public boolean testAdd(String jobName,String jobGroup,String triggerName,String triggerGroup,String cronExpression){
        try {
            JobDetail jobDetail = newJob(MyJob.class).withIdentity(jobName, jobGroup).build();
            Trigger trigger= newTrigger().withIdentity(triggerName, triggerGroup).withSchedule(cronSchedule(cronExpression)).build();
            scheduler.scheduleJob(jobDetail,trigger);
            return true;
        } catch (SchedulerException e) {

            e.printStackTrace();
            return false;
        }

    }
//    暂停调度器
    @RequestMapping("/test1")
    public boolean test1(String j1,String g1){
        try {
            scheduler.pauseJob(new JobKey(j1,g1));
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }

    }
//    恢复调度任务
    @RequestMapping("/test2")
    public boolean test2(String j1,String g1){
        try {
            scheduler.resumeJob(new JobKey(j1,g1));
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
    }

}
