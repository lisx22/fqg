package com.fqg.util.quartzutil;

import com.fqg.service.qiantai.IRepayService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/14
 * @Time 11:33
 */
public class ReCalcThisMonthRepayJob implements Job {

    @Resource
    private IRepayService repayService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        repayService.reCalcThisMonthRepay();
    }
}
