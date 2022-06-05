package com.zyc.shiro.web.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @AUTHOR yachao.zhang
 * @DATE 2022/5/29
 * @Description
 */
@Slf4j
public class DefinitionRealm extends AuthorizingRealm {

    public DefinitionRealm() {
        log.info("init DefinitionRealm start...");
    }

    /**
     * 授权
     * @param principals // 用户认证凭证信息
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * @Description 认证接口
     * @param token 传递登录token
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从AuthenticationToken中获得登录名称
        return null;
    }

}
