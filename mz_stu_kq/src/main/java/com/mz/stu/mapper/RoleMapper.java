package com.mz.stu.mapper;

import com.mz.stu.entity.Role;
import com.mz.stu.query.RoleQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 12:02
 * @Email: 2579692606@qq.com
 */
@Mapper
public interface RoleMapper {
    /**
     * 通过用户id查询角色
     * @param userid
     * @return
     */
    List<Role> listRoleByUserId(Long userid);

    Long queryTotal(RoleQuery roleQuery);

    List<Role> queryData(RoleQuery roleQuery);

    @Insert("insert into t_role(name,sn,`desc`) values ('${name}','${sn}',trim('<![CDATA[${desc}]]>'))")
    void saveRole(Role role);

    @Delete("delete from t_role_permission  where roleid = #{roleid}")
    void deleteRolePermission(long parseLong);

    //添加角色对应的权限
    void addRolePermission(List rolePermissionList);

    @Delete("delete from t_role where id=#{id}")
    void deleteRole(Long id);

    @Select("select * from t_role")
    List<Role> queryAll();

    //删除用户角色
    @Delete("delete from t_user_role where userid = #{userId}")
    void deleteUserRole(Long userId);

    //添加用户角色
    void addUserRole(List userRoles);
}
