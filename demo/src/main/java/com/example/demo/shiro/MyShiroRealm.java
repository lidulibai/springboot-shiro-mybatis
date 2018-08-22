package com.example.demo.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.web.model.SysUser;
import com.example.demo.web.service.ISysRoleService;
import com.example.demo.web.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    // 如果项目中用到了事务，@Autowired注解会使事物失效，可以自己用get方法获取值
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private IUserService userService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        log.info("################ 执行 Shiro 凭证认证. ######################");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        SysUser user = new SysUser();
        user.setName(name);
        user.setPassword(password);
        // 从数据库获取对应用户名密码的用户
        SysUser userLogin = userService.getUser(user);
        if (userLogin != null) {
            // 用户为禁用状态
            if (userLogin.getState() != 1) {
                throw new DisabledAccountException();
            }
            log.info("################ Shiro 凭证认证成功. ######################");
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userLogin, //用户
                    userLogin.getPassword(), //密码
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /* 
        * 权限认证
     * @Param PrincipalCollection
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("################ 执行 Shiro 权限获取. #####################");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof SysUser) {
            SysUser userLogin = (SysUser) principal;
            Set<String> roles = roleService.findRoleNameByUserId(userLogin.getId());
            authorizationInfo.addRoles(roles);

            Set<String> permissions = userService.findPermissionsByUserId(userLogin.getId());
            authorizationInfo.addStringPermissions(permissions);
        }
        log.info("#### 获取到以下权限 ####");
        log.info(authorizationInfo.getStringPermissions().toString());
        log.info("################ Shiro 权限获取成功. ######################");
        return authorizationInfo;
    }
}
