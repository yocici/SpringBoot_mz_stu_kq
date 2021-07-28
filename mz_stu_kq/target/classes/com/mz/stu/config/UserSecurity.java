package com.mz.stu.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

//登录用户封装
public class UserSecurity extends User {
    com.mz.stu.entity.User loginUser;
    public UserSecurity(com.mz.stu.entity.User user, Set<GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(),true,true,true,true, authorities);
        this.loginUser = user;
    }
    public com.mz.stu.entity.User getLoginUser() {
        return loginUser;
    }
    public void setLoginUser(com.mz.stu.entity.User loginUser) {
        this.loginUser = loginUser;
    }
}
