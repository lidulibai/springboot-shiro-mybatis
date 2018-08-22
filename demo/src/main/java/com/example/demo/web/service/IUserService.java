package com.example.demo.web.service;

import java.util.List;
import java.util.Set;

import com.example.demo.web.model.SysUser;

public interface IUserService {

	public List<SysUser> findAll();
	
	public void saveUser(SysUser user);
	
	public SysUser findOne(long id);
	
	public void delete(long id);
	
	public List<SysUser> findByName(String name);
	
	public Set<String> findPermissionsByUserId(long id);
	
	public SysUser getUser(SysUser user);
}
