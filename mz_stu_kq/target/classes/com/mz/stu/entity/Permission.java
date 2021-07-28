package com.mz.stu.entity;

import lombok.Data;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 11:20
 * @Email: 2579692606@qq.com
 */
@Data
public class Permission {

    private Long id;
    private String name;
    private String title;
    private Long pid;
    private Long menuid;
}