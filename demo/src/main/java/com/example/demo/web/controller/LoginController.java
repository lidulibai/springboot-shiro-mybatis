package com.example.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.web.model.SysUser;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/auth")
@Slf4j
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public String submitLogin(String username, String password, HttpServletRequest request) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (DisabledAccountException e) {
            request.setAttribute("msg", "账户已被禁用");
            log.info("账户已被禁用");
            return "login";
        } catch (AuthenticationException e) {
            request.setAttribute("msg", "用户名或密码错误");
            log.info("用户名秘密错误");
            return "login";
        }

        // 执行到这里说明用户已登录成功
        return "redirect:/auth/index";
    }


    @GetMapping("/login")
    public String loginPage() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/auth/index";
        }
        return "login";
    }

    @GetMapping("/index")
    public String loginSuccessMessage(HttpServletRequest request) {
        String username = "未登录";
        SysUser currentLoginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();

        if (currentLoginUser != null && StringUtils.isNotEmpty(currentLoginUser.getName())) {
            username = currentLoginUser.getName();
        } else {
            return "redirect:/auth/login";
        }
        request.setAttribute("username", username);
        return "index";
    }

    //被踢出后跳转的页面
    @GetMapping("/kickout")
    public String kickOut() {
        return "kickout";
    }
    
    /**
        * 退出
     * @return {Result}
     */
    @PostMapping("/logout")
    public Object logout() {
        log.info("登出");
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())
            subject.logout();
        return "redirect:/auth/login";
    }

}
