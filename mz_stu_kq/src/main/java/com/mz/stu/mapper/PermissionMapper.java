package com.mz.stu.mapper;

import com.mz.stu.entity.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 12:02
 * @Email: 2579692606@qq.com
 */
@Mapper
public interface PermissionMapper {
    List<Permission> listPermissionByUserId(Long userid);

    /**
     * 添加页面权限
     */
    void addMenuPermission(Permission permission);

    /**
     * 查询所有的权限
     */
    @Select("select * from t_permission")
    List<Permission> findAllPermisisons();

    @Insert("insert into t_permission (name,title,pid) values(#{name},#{title},#{pid})")
    void addBtnPermission(Permission permission);

    /**
     * 根据权限id 删除权限表数据
     * @param id
     */
    @Delete("delete from t_permission where id=#{id}")
    void deletePermisisonByPid(Long id);

    /**
     * 根据权限id 删除权限中间表数据
     * @param id
     */
    @Delete("delete from t_role_permission where permissionid=#{id}")
    void deleteRolePermisisonByPid(Long id);

    /**
     * 修改页面权限
     * insert into t_permission (name,title,pid,menuid)
     * 		values(#{name},#{title},#{pid},#{menuid})
     */
    @Update("update t_permission set name=#{name},title=#{title} where id=#{id}")
    void editBtnPermisison(Permission permission);
}
