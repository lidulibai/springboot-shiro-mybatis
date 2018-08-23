package com.example.demo.web.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.web.mapper.UserMapper;
import com.example.demo.web.model.SysUser;
import com.example.demo.web.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    
    @Override
    public List<SysUser> findAll() {
        return userMapper.selectPage(new Page<SysUser>(1, 10), new EntityWrapper<SysUser>());
//        return userMapper.findAll();
    }

    @Override
    public void saveUser(SysUser user) {
        userMapper.insert(user);

    }

    @Override
    public SysUser findOne(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public void delete(long id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<SysUser> findByName(String name) {
        return userMapper.selectList(new EntityWrapper<SysUser>().eq("name", name));
    }

    @Override
    public Set<String> findPermissionsByUserId(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SysUser getUser(SysUser user) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<SysUser> getUserByAccount(String account) {
        return userMapper.selectList(new EntityWrapper<SysUser>().eq("account", account));
    }
    
    @Override
    public SysUser getUserByAccountAndPassword(SysUser user) {
        List<SysUser> userList = userMapper.selectList(new EntityWrapper<SysUser>().eq("account", user.getAccount()).eq("password", user.getPassword()));
        if(userList.isEmpty()) {
            return null;
        } else {
            return userList.get(0);
        }
    }

}
