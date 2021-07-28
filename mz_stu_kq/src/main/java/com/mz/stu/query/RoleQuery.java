package com.mz.stu.query;

import lombok.Data;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/27 8:37
 * @Email: 2579692606@qq.com
 */
@Data
public class RoleQuery {
    //开始位置
    private Integer offset = 0;
    //每页显示条数
    private Integer pageSize = 10;
}
