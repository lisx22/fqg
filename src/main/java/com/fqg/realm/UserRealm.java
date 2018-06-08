package com.fqg.realm;

import com.fqg.dao.CustomerMapper;
import com.fqg.entity.Customer;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 用户登录
 */
public class UserRealm extends AuthorizingRealm{
    //    返回值和类名保持一致
    @Override
    public String getName() {
        return "UserRealm";
    }

    @Resource
    private CustomerMapper customerMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用来判断用户名和密码是否正确
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //是用户输入的用户名
        String username = usernamePasswordToken.getUsername();

        //跟数据库的用户名进行对比
        Customer customer = null;
        try {
            customer = customerMapper.selectByPrimaryKey(username);
        } catch (Exception e) {
            e.printStackTrace();

        }
        //判断用户名是否存在
        if (customer == null) {
            throw new UnknownAccountException("没有用户名：" + username);
        }
        //判断密码
        //数据库的密码
        String dbPassword = customer.getLoginPassword();
        char[] tokenPassword = usernamePasswordToken.getPassword();
        String userPassword = new String(tokenPassword);
        if (null == dbPassword || !dbPassword.equals(userPassword)) {
            throw new IncorrectCredentialsException("密码错误，不是你的别乱试");
        }
        //验证用户名和密码成功，返回认证信息
        //参数1：用户名
        //参数2：密码
        //参数3：当前realm的名称
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, dbPassword, getName());
        return authenticationInfo;
    }
}
