package com.baizhi.config;

import com.baizhi.job.MyJob;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by wdwhwn on 2018/11/9.
 * 1 创建配置类
 * 2 管理schedule 工厂   形参需要导入CronTrigger对象
 * 3 管理jobDedail  注入name  group
 * 4 管理trigger  注入JobDetail对象  name group 表达式
 *
 */
@Configuration
public class QuartzConfig {
    @Bean
    public SchedulerFactoryBean stdSchedulerFactory(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setTriggers(cronTrigger);
//        schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz-cluster.properties"));
        return schedulerFactoryBean;
    }


    public JobDetailFactoryBean createJFB(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(MyJob.class);
//        jobDetailFactoryBean.setName("myJob2");
//        jobDetailFactoryBean.setGroup("g1");
        return jobDetailFactoryBean;
    }

    public CronTriggerFactoryBean createCFB(JobDetail jobDetail){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
//        cronTriggerFactoryBean.setName("myTrigger1");
//        cronTriggerFactoryBean.setGroup("g1");
//        cronTriggerFactoryBean.setCronExpression("0/3 * * * * ? 2018");
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        return cronTriggerFactoryBean;
    }
}
