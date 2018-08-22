package com.example.demo.web.service;

import java.util.Set;

public interface ISysRoleService {

    public Set<String> findRoleNameByUserId(long id);
}
