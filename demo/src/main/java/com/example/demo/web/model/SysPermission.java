package com.example.demo.web.model;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@Data
@TableName("sys_permission")
public class SysPermission {

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    
    @TableField("permission")
    private String permission;
    
    private List<SysRole> role;
}
