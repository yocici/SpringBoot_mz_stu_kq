package com.mz.stu.serivce;




import com.mz.stu.entity.Role;
import com.mz.stu.query.RoleQuery;
import com.mz.stu.util.PageList;

import java.util.List;

public interface IRoleService {
    //根据用户id查询角色
    List<Role> listRoleByUserId(Long userid);

    PageList listpage(RoleQuery roleQuery);


    void saveRole(Role role);

    //添加角色对应的权限
    void addRolePermission(String roleId, List permissionIds);

    void deleteRole(Long id);

    List<Role> queryAll();

    //添加角色
    void addUserRole(String userId, List roleIds);
}
