package com.example.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.example.demo.web.model.SysUser;

public class ShiroUtil {

    /**
     * 获取当前Subject
     * @return Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    
    public static SysUser getCurrentUser() {
        return (SysUser) getSubject().getPrincipals().getPrimaryPrincipal();
    }
}
