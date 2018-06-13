package com.fqg.controller.manager;

import com.fqg.entity.Admin;
import com.fqg.service.manager.impl.AdminServiceImpl;
import com.fqg.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/managerUser")
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;

    @RequestMapping("/amdinLogin")
    public String login(String username, String password, Model model){
        System.out.println("amdinLogin");
        Admin admin = adminService.login(username, password);
        JsonResult jsonResult = new JsonResult();

        if(admin==null){
            jsonResult.setMsg("账号或密码错误");
            jsonResult.setCode(1);
            model.addAttribute("jsonResult",jsonResult);
            return "manager_login.ftl";
        }else{
            jsonResult.setMsg("登录成功");
            jsonResult.setCode(0);
            return "manager_index.ftl";
        }


    }

}
