package com.zyc.aop.controller;

import com.zyc.aop.service.TestService;
import com.zyc.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    private TestService testService;

    @Value("${spring.qwe-re.ff:0}")
    private Integer age;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/v1/test/aop1")
    public ResponseEntity testAop(){
        String taskResult = testService.executorService1("任务一");
        return ResponseEntity.ok(Result.success(taskResult));
    }

    @GetMapping("/v1/test/aop2")
    public ResponseEntity testAop2(){
        String taskResult = testService.executorService2("任务二");
        return ResponseEntity.ok(Result.success(taskResult));
    }

    @GetMapping("/v1/test/aop3")
    public ResponseEntity testAop3(){
        //int a = 7/0;
        //throw new RuntimeException("aaaa");
        return ResponseEntity.ok(Result.success());
    }

}
