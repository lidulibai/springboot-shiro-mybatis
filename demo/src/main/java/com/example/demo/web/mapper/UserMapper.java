package com.example.demo.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.web.model.SysUser;

@Repository
public interface UserMapper extends BaseMapper<SysUser> {

    List<SysUser> findAll();
}
