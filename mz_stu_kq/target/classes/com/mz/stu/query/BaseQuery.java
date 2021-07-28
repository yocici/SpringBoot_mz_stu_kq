package com.mz.stu.query;

import lombok.Data;

/**
 * @description: TODO
 * @author: soulcoder-码仔项目库分享圈
 * @qq: 交流咨询 qq2579692606
 * @datetime: 2020/7/1 14:44
 */
@Data
public class BaseQuery {
    //开始位置
    private Integer offset = 0;
    //每页显示条数
    private Integer pageSize = 10;
}
