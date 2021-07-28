package com.mz.stu.serivce.impl;

import com.mz.stu.entity.Classes;
import com.mz.stu.entity.User;
import com.mz.stu.mapper.UserMapper;
import com.mz.stu.query.UserQuery;
import com.mz.stu.serivce.IClassesService;
import com.mz.stu.serivce.IUserService;
import com.mz.stu.util.PageList;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.userdetails.UserDetailsMapFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 11:28
 * @Email: 2579692606@qq.com
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IClassesService classesService;

    public User findUserByUserName(String username){
        return userMapper.findUserByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public PageList listpage(UserQuery userQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = userMapper.queryTotal(userQuery);
        List<User> users = userMapper.queryData(userQuery);
        pageList.setTotal(total);
        pageList.setRows(users);
        //分页查询的数据
        return pageList;
    }

    //添加用户
    @Override
    public void addUser(User user) {
        //设置创建时间
        user.setCreateTime(new Date());
        //加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePwd);

        //判断 如果是学生用户
        if (user.getType() == 3) {
            Classes classes = classesService.findOne(user.getClassesid());
            user.setTid(classes.getTid());
        }
        userMapper.addUser(user);
    }

    @Override
    public void updateUserHeadImg(User user) {
        userMapper.updateUserHeadImg(user);
    }

    /**
     * 修改用户
     */
    @Override
    public void editSaveUser(User user) {
        userMapper.editSaveUser(user);
    }
    /**
     * 删除用户
     */
    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }
    /**
     * 批量删除
     */
    @Override
    public void batchRemove(List list) {
        userMapper.batchRemove(list);
    }
    /**
     * 学生选课
     */
    @Override
    public void editSaveXk(User user) {
        userMapper.editSaveXk(user);
    }

    @Override
    public User findOne(Long id) {
        return  userMapper.findOne(id);
    }
}
