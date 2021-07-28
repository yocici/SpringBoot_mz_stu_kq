package com.mz.stu.serivce;




import com.mz.stu.entity.Permission;

import java.util.List;

public interface IPermissionService {

    //根据用户查询权限
    List<Permission> listPermissionByUserId(Long userid);

    List<Permission> findAllPermisisons();
    /**
     * 添加页面按钮权限
     */
    void addBtnPermisison(Permission permission);
    /**
     * 删除权限
     */
    void deletePermisisonByPid(Long id);
    /**
     * 修改页面按钮权限
     */
    void editBtnPermisison(Permission permission);
}
