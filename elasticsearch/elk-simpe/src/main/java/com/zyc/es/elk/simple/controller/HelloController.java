package com.zyc.es.elk.simple.controller;

import com.zyc.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/v1/helloworld")
    public ResponseEntity helloWorld(){
        log.info("hello world");
        return ResponseEntity.ok(Result.success());
    }

}
