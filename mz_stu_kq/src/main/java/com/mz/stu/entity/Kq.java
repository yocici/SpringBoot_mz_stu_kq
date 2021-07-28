package com.mz.stu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description: 考勤实体类
 * @author: soulcoder-码仔项目库分享圈
 * @qq: 交流咨询 qq2579692606
 * @datetime: 2020/7/1 14:40
 */
@Data
public class Kq {

    private Long id;
    //用户id
    private Long userid;
    private User user;
    //上课打卡时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date upClassTime;
    //放学打卡时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date downClassTime;
    //日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date currentTime;

    private Long tid;
}
