package com.mz.stu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 11:20
 * @Email: 2579692606@qq.com
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String tel;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Boolean sex;
    private String headImg;
    private Integer type; //type=1 是管理员  type=2是老师
    private List<Role> roles = new ArrayList();//用户对应的角色集合

    /**
     *     学生学号
     */
    private String stunum;

    /**
     * 班级id
     */
    private Long classesid;
    /**
     * 学生所属班级
     */
    private Classes classes;

    /**
     * 班级所带老师
     */
    private Long tid;

    //用户组id
    private String groupId;

    public User() {
    }
}
