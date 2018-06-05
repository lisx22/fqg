package com.fqg.controller.manager;

import com.fqg.entity.Admin;
import com.fqg.service.manager.impl.AdminServiceImpl;
import com.fqg.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/managerUser")
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;

    @RequestMapping("/amdinLogin")
    public String login(String username,String password){
        System.out.println("amdinLogin");
        Admin admin = adminService.login(username, password);
        JsonResult jsonResult = new JsonResult();

        if(admin==null){
            jsonResult.setMsg("账号或密码错误");
            jsonResult.setCode(1);
            System.out.println("shibai");
        }else{
            jsonResult.setMsg("登录成功");
            jsonResult.setCode(0);
            System.out.println("chenggong");
        }

        return  "index_manager";
    }

}
