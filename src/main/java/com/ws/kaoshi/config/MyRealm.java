package com.ws.kaoshi.config;

import com.ws.kaoshi.beans.User;
import com.ws.kaoshi.dao.PermissionsDao;
import com.ws.kaoshi.dao.RoleDao;
import com.ws.kaoshi.dao.UserDao;
import lombok.val;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

//1.创建一个类继承AuthorizingRealm类（实现了Realm接口的类）
//2.重写doGetAuthorizationInfo和doGetAuthenticationInfo方法
//3.重写getName方法
public class MyRealm extends AuthorizingRealm{

    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private PermissionsDao permissionsDao;

    public String getName()
    {
        return "myRealm";
    }

    //获取授权数据
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户的用户名
        String username = (String)principalCollection.iterator().next();
        //根据用户名查询当前用户的角色列表
    Set<String> roleName = roleDao.queryRoleNamesByUsername(username);
        //根据用户名查询当前用户的权限列表
        Set<String> ps = permissionsDao.queryPermissionsByUsername(username);
        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
        info.setRoles(roleName);
        info.setStringPermissions(ps);

        return info;
    }


  //获取认证数据(从数据库查到用户的正确数据)
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token =(UsernamePasswordToken) authenticationToken;
        String username =token.getUsername();
        //根据用户名，从数据库查询当前用户的安全数据
            User user = userDao.queryUserByUsername(username);
       if(user==null){
           return null;
       }
        AuthenticationInfo info =new SimpleAuthenticationInfo(username,user.getUserPwd(),getName());
        return info;
    }
}
