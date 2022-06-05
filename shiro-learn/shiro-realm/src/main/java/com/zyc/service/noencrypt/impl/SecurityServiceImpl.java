package com.zyc.service.noencrypt.impl;

import com.zyc.service.noencrypt.SecurityService;
import com.zyc.shiro.encode.tool.DigestsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SecurityServiceImpl implements SecurityService {

    @Override
    public String findPasswordByLoginName(String loginName) {
        return "123";
    }

    @Override
    public Map<String, String> findPasswordByLoginNameEncrypt(String loginName) {
        return DigestsUtil.entryptPassword("123");
    }

    @Override
    public List<String> findRoleByloginName(String loginName) {
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("dev");
        return list;

    }

    @Override
    public List<String> findPermissionByloginName(String loginName) {
        List<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:list");
        list.add("order:del");
        return list;
    }
}
