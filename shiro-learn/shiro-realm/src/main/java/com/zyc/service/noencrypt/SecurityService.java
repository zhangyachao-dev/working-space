package com.zyc.service.noencrypt;

import java.util.List;
import java.util.Map;

public interface SecurityService {
    /**
     * @Description 查找密码按用户登录名
     * @param loginName 登录名称
     * @return
     */
    String findPasswordByLoginName(String loginName);

    /**
     * @Description 加密-查找密码按用户登录名
     * @param loginName 登录名称
     * @return
     */
    Map<String,String> findPasswordByLoginNameEncrypt(String loginName);

    /**
     * @Description 查找角色按用户登录名
     * @param loginName 登录名称
     * @return
     */
    List<String> findRoleByloginName(String loginName);
    /**
     * @Description 查找资源按用户登录名
     * @param loginName 登录名称
     * @return
     */
    List<String> findPermissionByloginName(String loginName);

}
