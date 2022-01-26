package com.zyc.aop.service.impl;

import com.zyc.aop.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public String executorService1(String task) {
        log.info("参数：{}", task);
        log.info("executorService1 执行业务。。。");
        return "我是结果1";
    }

    @Override
    public String executorService2(String task) {
        log.info("executorService2 执行业务。。。");
        return "我是结果2";
    }

}
