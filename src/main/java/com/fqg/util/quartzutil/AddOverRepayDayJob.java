package com.fqg.util.quartzutil;

import com.fqg.service.qiantai.IRepayService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/14
 * @Time 11:29
 */
@Component
public class AddOverRepayDayJob implements Job {

    @Resource
    private IRepayService repayService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("do addOverRepayDay");
        repayService.addOverRepayDay();
    }

}


