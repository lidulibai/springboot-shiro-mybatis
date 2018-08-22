package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.web.model.SysUser;
import com.example.demo.web.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/add/{id}/{name}/{address}")
	public SysUser addUser(@PathVariable int id, @PathVariable String name, @PathVariable String address) {
		log.info("===================><==================");
		SysUser user = new SysUser();
		user.setId(id);
		user.setName(name);
		user.setAddress(address);
		user.setCreator("test");
		userService.saveUser(user);
		return user;
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.delete(id);
	}
	
	@RequestMapping(value = "/")
	public List<SysUser> getUsers() {
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{id}")
	public SysUser getUser(@PathVariable int id) {
		return userService.findOne(id);
	}
	
	@RequestMapping(value = "/search/name/{name}")
	public List<SysUser> getUserByName(@PathVariable String name) {
		return userService.findByName(name);
	}
}
