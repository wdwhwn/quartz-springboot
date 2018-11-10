package com.baizhi.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wdwhwn on 2018/11/9.
 */
/*@Component*/
public class QuartzTest {
  /*  @Scheduled(cron="0/5 * * * * ?")*/
    public void quartzTest(){
        System.out.println("hello"+new Date());
    }
}
