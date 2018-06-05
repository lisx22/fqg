package com.fqg.service.manager.impl;

import com.fqg.dao.AdminMapper;
import com.fqg.entity.Admin;
import com.fqg.service.manager.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminMapper adminDAO;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminDAO.login(username,password);
        return admin;
    }
}
