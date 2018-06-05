package com.fqg.service.manager;

import com.fqg.entity.Admin;

public interface AdminService {
    Admin login(String username,String password);
}
