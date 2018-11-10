package com.baizhi.test;

import com.baizhi.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wdwhwn on 2018/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestA {
    @Autowired
    private Scheduler scheduler;
    @Test
    public void test(){
        System.out.println(scheduler);
    }
}
