package com.mz.stu.config;


import com.mz.stu.entity.Permission;
import com.mz.stu.entity.Role;
import com.mz.stu.serivce.IPermissionService;
import com.mz.stu.serivce.IRoleService;
import com.mz.stu.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    //查询用户和角色
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询出用户
        com.mz.stu.entity.User user = userService.findUserByUserName(username);
        if(user != null) {
            //查询角色集合
            Long userid = user.getId();
            List<Role> roles = roleService.listRoleByUserId(userid);
            //查询权限集合
            List<Permission> permissions = permissionService.listPermissionByUserId(userid);
            //构建所有权限集合==ROLE_角色+权限
            HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            }
            for (Permission permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            }
            return new UserSecurity(user,authorities);
        }else{
            return null;
        }
    }
}
