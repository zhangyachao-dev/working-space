package com.zyc.mp.controller;

import com.zyc.mp.entity.MpUserEntity;
import com.zyc.mp.service.MpUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2021-01-02
 */
@RestController
@RequestMapping("/mp")
@Slf4j
@Api(value = "用户模块接口",tags = "用户")
public class MpUserController {

    @Autowired
    private MpUserService mpUserService;

    @GetMapping("/hello")
    @ApiOperation(value = "hello world")
    public ResponseEntity<String> hello(){
        String welcome = "mybatis plus hello world";
        log.info(welcome);
        return new ResponseEntity<>(welcome, HttpStatus.OK);
    }

    @GetMapping("/users")
    @ApiOperation(value = "用户列表")
    public ResponseEntity<List<MpUserEntity>> queryList(){
        List<MpUserEntity> list = mpUserService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "插入用户")
    public ResponseEntity<Object> createUser(@RequestBody MpUserEntity mpUserEntity){
        boolean save = mpUserService.save(mpUserEntity);
        return ResponseEntity.ok(save);
    }

}

