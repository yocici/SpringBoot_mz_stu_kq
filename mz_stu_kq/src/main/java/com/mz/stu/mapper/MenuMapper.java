package com.mz.stu.mapper;

import com.mz.stu.entity.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/23 22:39
 * @Email: 2579692606@qq.com
 */
@Mapper
public interface MenuMapper {
    /**
     * 根据登录用户 查询菜单
     * @param loginUserid
     * @return
     */
    List<Menu> findAll(Long loginUserid);

    /**
     * 查询所有的菜单
     * @return
     */
    List<Menu> queryAllMenu();

    /**
     * 保存一级菜单
     * @param menu
     */
    void addTopMenu(Menu menu);

    //保存子菜单
    void addSubMenu(Menu menu);


    @Delete("delete from t_menu where id=#{id} or pid=#{id}")
    void deleteMenuById(Long id);


    void editMenu(Menu menu);
}
