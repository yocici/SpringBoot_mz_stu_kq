package com.mz.stu.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 11:20
 * @Email: 2579692606@qq.com
 */
@Data
public class Role {
    private Long id;
    private String name;
    private String sn;
    private String desc;
    List<Permission> permissions = new ArrayList();
}
