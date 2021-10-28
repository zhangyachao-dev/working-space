package com.zyc.mp.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyc.mp.entity.DictionaryEntity;
import com.zyc.mp.entity.OperationLogEntity;
import com.zyc.mp.service.OperationLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author yachao.zhang
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/operationLog/v1")
@Api(value = "操作日志模块接口",tags = "日志")
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/list-all")
    @ApiOperation(value = "查询列表")
    public ResponseEntity<Object> queryList(){
        List<OperationLogEntity> logEntities = operationLogService.list();
        return ResponseEntity.ok(logEntities);
    }
    @GetMapping("/list-page")
    @ApiOperation(value = "分页查询列表")
    public ResponseEntity<Object> queryListPage(int pageNo, int pageSize){
        Page<OperationLogEntity> page = new Page<>(pageNo,pageSize);
        Page<OperationLogEntity> entityPage = operationLogService.page(page);
        return ResponseEntity.ok(entityPage);
    }

}

