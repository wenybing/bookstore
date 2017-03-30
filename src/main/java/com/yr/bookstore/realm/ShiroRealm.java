package com.yr.bookstore.realm;

import com.yr.bookstore.user.bean.User;
import com.yr.bookstore.user.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/1.
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /**
         * 1. 从 PrincipalCollection 中来获取登录用户的信息
         */
        Object princiapl = principals.getPrimaryPrincipal();
        /**
         * 2. 利用登录的用户的信息来获取当前用户的角色或权限(可能需要查询数据库)
         */
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        if("admin".equals(princiapl)){
           roles.add("admin");
        }

        /**
         * 3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
         */
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        /**
         * 4. 返回 SimpleAuthorizationInfo 对象.
         */
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /**
         *  1. 把 AuthenticationToken 转换为 UsernamePasswordToken
         */
        UsernamePasswordToken UPToken = (UsernamePasswordToken) token;
        /**
         *   2. 从 UsernamePasswordToken 中来获取 username
         */
        String username = UPToken.getUsername();
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        User login = userServiceImpl.getUserByUserName(username);
        /**
         *    //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
         */
        if(login == null){
            throw new UnknownAccountException("用户名不存在！");
        }
        /**
         *  6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
         // 以下信息是从数据库中获取的.
         // 1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
         // 2). credentials: 密码.
         */
        /**
         * Object principal = username;
         * Object credentials = "abc123";
         * String realmName = getName();
         * 3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
         * SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,realmName);
         */
        Object principal = login.getUsername();
        Object hashedCredentials = login.getPassword();
        ByteSource credentialsSalt = ByteSource.Util.bytes(login.getUsername());
        String realmName = getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,hashedCredentials,credentialsSalt,realmName);
        return info;
    }
}
