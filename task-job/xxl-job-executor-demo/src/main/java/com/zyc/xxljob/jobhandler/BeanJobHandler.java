package com.zyc.xxljob.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanJobHandler {

    private static Logger logger = LoggerFactory.getLogger(BeanJobHandler.class);

    @XxlJob("demoJobHandler")
    public void demoJobHandler1(){
        logger.info("task job start...");
        XxlJobHelper.log("hello word zyc");
        logger.info("task job end...");
    }


}
