package com.example.demo.web.model;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user")
public class SysUser extends BaseModle {

    @TableId(value = "id", type = IdType.ID_WORKER)
	private long id;
    
	@TableField("name")
	private String name;
	
	@TableField("address")
	private String address;
	
	@TableField("password")
	private String password;
	
	@TableField("salt")
	private String salt;
	
	@TableField(exist = false)
    private List<SysRole> roles;
}
