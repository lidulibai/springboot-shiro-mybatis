package com.example.demo.web;

import java.util.Date;

import org.junit.Test;

import com.example.demo.web.model.SysUser;

public class TestWeb {

    @Test
    public void testInserUser() {
        SysUser user = new SysUser();
        user.setName("test");
        user.setPassword("test");
        user.setAddress("test");
        user.setCreateTime(new Date());
        user.setCreator("admin");
        user.setSalt("sfsdfsdfsd");
        user.setUpdateTime(new Date());
        user.setUpdator("admin");
    }
}
