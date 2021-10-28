package com.zyc.mp.controller;


import com.zyc.mp.entity.DictionaryEntity;
import com.zyc.mp.service.DictionaryService;
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
 * 字典表	 前端控制器
 * </p>
 *
 * @author yachao.zhang
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/dictionary")
@Api(value = "字典模块接口",tags = "字典")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/list-all")
    @ApiOperation(value = "查询列表")
    public ResponseEntity<Object> queryList(){
        List<DictionaryEntity> dictionaries = dictionaryService.list();
        return ResponseEntity.ok(dictionaries);
    }
}

