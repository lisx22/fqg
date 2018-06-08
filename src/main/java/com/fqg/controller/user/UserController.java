package com.fqg.controller.user;

import com.fqg.entity.Customer;
import com.fqg.service.user.UserService;
import com.fqg.util.HttpUtils;
import com.fqg.util.JsonResult;
import com.fqg.util.SystemParam;
import com.fqg.util.SystemTools;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    @Resource
    private UserService userServiceImpl;
    private Customer customer = new Customer();
    JsonResult jsonResult = null;
//    登录
    @RequestMapping("/login")
    public Object login(String username, String password, HttpServletRequest req,
                        String vcode,Model model){
        System.out.println("进入方法1"+vcode);
        Object vcode1 = req.getSession().getAttribute("vcode");
        System.out.println(vcode1);
        try {
//            验证验证码
            if(vcode==null||!vcode.equals(req.getSession().getAttribute("vcode"))) {
                jsonResult = SystemTools.formatJsonResult(SystemParam.Login.CODE_FAIL_UNKOWN_ACCOUNT, SystemParam.Login.MSG_FAIL_UNKOWN_ACCOUNT);
                return jsonResult;
            }
            userServiceImpl.login(username,password);
            jsonResult = SystemTools.formatJsonResult(SystemParam.Login.CODE_SUCCESS,SystemParam.Login.MSG_SUCCESS);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            jsonResult = SystemTools.formatJsonResult(SystemParam.Login.CODE_FAIL_UNKOWN_ACCOUNT, SystemParam.Login.MSG_FAIL_UNKOWN_ACCOUNT);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            jsonResult = SystemTools.formatJsonResult(SystemParam.Login.CODE_FAIL_INCORRECT_PASSWORD,SystemParam.Login.MSG_FAIL_INCORRECT_PASSWORD);
        }
        System.out.println("成功执行");
        System.out.println(jsonResult);
        return jsonResult;
    }
//    注册
    @RequestMapping("/save")
    public Object save(String username,String password,String loginpasswprd
            ,HttpSession httpSession,String inputCode,Model model){
        String sendCode=(String)httpSession.getAttribute("sendCode");
        String userTel=(String)httpSession.getAttribute("userTel");
        System.out.println(sendCode+"===="+userTel+"-------"+inputCode);
        if (!inputCode.equals(sendCode)||!userTel.equals(username)){
            model.addAttribute("msg","验证码错误");
            jsonResult = SystemTools.formatJsonResult(SystemParam.Login.CODE_FAIL_UNKOWN_ACCOUNT, SystemParam.Login.MSG_FAIL_UNKOWN_ACCOUNT);
            return jsonResult;
        }
        try {
            System.out.println("进入方法");
            customer.setPhoneNumber(username);
            customer.setLoginPassword(password);
            customer.setPayPassword(loginpasswprd);
            Customer save = userServiceImpl.save(customer);
            if(save==null){
                jsonResult = SystemTools.formatJsonResult(SystemParam.Login.CODE_FAIL_UNKOWN_ACCOUNT, SystemParam.Login.MSG_FAIL_UNKOWN_ACCOUNT);
                return jsonResult;
            }
            jsonResult = SystemTools.formatJsonResult(SystemParam.Login.CODE_SUCCESS,SystemParam.Login.MSG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
//    验证
@RequestMapping("/send")
public void send(String userTel, HttpSession httpSession){
        /*生成随机四位数短信验证码*/
    String base = "0123456789";
    Random random = new Random();
    StringBuffer num = new StringBuffer();
    for (int i = 0; i < 6; i++) {
        int number = random.nextInt(base.length());
        num.append(base.charAt(number));
    }
    String sendCode=num.toString();
    httpSession.setAttribute("sendCode",sendCode);
    httpSession.setAttribute("userTel",userTel);
    String host = "https://feginesms.market.alicloudapi.com";
    String path = "/codeNotice";
    String method = "GET";
    String appcode = "4f196c6d8efa49f99437c1b3e4a2123d";
    Map<String, String> headers = new HashMap<String, String>();
    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
    headers.put("Authorization", "APPCODE " + appcode);
    Map<String, String> querys = new HashMap<String, String>();
    querys.put("param",sendCode);
    querys.put("phone", userTel);
    querys.put("sign", "1");
    querys.put("skin", "1");


    try {
        /**
         * 重要提示如下:
         * HttpUtils请从
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
         * 下载
         *
         * 相应的依赖请参照
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
         */
        HttpResponse httpResponse = HttpUtils.doGet(host, path, method, headers, querys);
        //System.out.println(response.toString());
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
