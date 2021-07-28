package com.mz.stu.serivce;

import com.mz.stu.entity.User;
import com.mz.stu.query.UserQuery;
import com.mz.stu.util.PageList;

import java.util.List;


public interface IUserService {
    /**
     *  根据用户名取到用户
     */

    User findUserByUserName(String username);

    /**
     *  查找所有的用户
     */

    List<User> findAll();

    /**
     *     分页方法
     */

    PageList listpage(UserQuery userQuery);

    /**
     *     添加用户
     */
    void addUser(User user);
    /**
     * 更新用户头像
     */
    void updateUserHeadImg(User user);

    /**
     * 修改用户
     */
    void editSaveUser(User user);
    /**
     * 删除用户
     */
    void deleteUser(Long id);
    /**
     * 批量删除
     */
    void batchRemove(List list);
    /**
     * 学生选课
     */
    void editSaveXk(User user);

    User findOne(Long id);
}
