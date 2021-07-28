package com.mz.stu.serivce.impl;


import com.mz.stu.entity.Permission;
import com.mz.stu.mapper.PermissionMapper;
import com.mz.stu.serivce.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> listPermissionByUserId(Long userid) {
        return permissionMapper.listPermissionByUserId(userid);
    }

    //查找所有的权限
    @Override
    public List<Permission> findAllPermisisons(){
        return permissionMapper.findAllPermisisons();
    }

    @Override
    public void addBtnPermisison(Permission permission) {
        permissionMapper.addBtnPermission(permission);
    }

    /**
     *    删除权限
     */
    @Override
    @Transactional(rollbackFor=RuntimeException.class)
    public void deletePermisisonByPid(Long id) {
        try {
            //删除中间表数据
            permissionMapper.deleteRolePermisisonByPid(id);
            //删除权限表数据
            permissionMapper.deletePermisisonByPid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editBtnPermisison(Permission permission) {
        permissionMapper.editBtnPermisison(permission);
    }

}
