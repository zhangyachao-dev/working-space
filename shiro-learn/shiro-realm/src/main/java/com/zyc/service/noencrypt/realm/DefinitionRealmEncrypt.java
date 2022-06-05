package com.zyc.service.noencrypt.realm;

import com.zyc.service.noencrypt.SecurityService;
import com.zyc.service.noencrypt.impl.SecurityServiceImpl;
import com.zyc.shiro.encode.tool.DigestsUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR yachao.zhang
 * @DATE 2022/5/24
 * @Description
 */
public class DefinitionRealmEncrypt extends AuthorizingRealm {

    public DefinitionRealmEncrypt() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(DigestsUtil.SHA1);
        matcher.setHashIterations(DigestsUtil.ITERATIONS);
        setCredentialsMatcher(matcher);
    }

    /**
     * 授权
     * @param principals // 用户认证凭证信息
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String user = (String)principals.getPrimaryPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        List<String> roles = securityService.findRoleByloginName(user);
        List<String> permissions = securityService.findPermissionByloginName(user);
        //构建资源校验
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * @Description 认证接口
     * @param token 传递登录token
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从AuthenticationToken中获得登录名称
        String loginName = (String) token.getPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        Map<String, String> map = securityService.findPasswordByLoginNameEncrypt(loginName);
        if (map.isEmpty()){
            throw new UnknownAccountException("账户不存在");
        }
        String salt = map.get("salt");
        String password = map.get("password");
        //传递账号和密码:参数1：缓存对象，参数2：明文密码，参数三：字节salt,参数4：当前DefinitionRealm名称
        return  new SimpleAuthenticationInfo(loginName,password, ByteSource.Util.bytes(salt),getName());
    }
}
