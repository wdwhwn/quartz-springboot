package com.baizhi.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by wdwhwn on 2018/11/9.
 */
public class MyJob extends QuartzJobBean{
    int n=0;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        n=n+1;
        System.out.println("SpringBoot集成Quartz"+new Date()+" "+n);
    }
}
