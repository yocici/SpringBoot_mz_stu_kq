package com.mz.stu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description:Leave 请假实体类
 */
@Data
public class Leave extends BaseEntity{
    /**
     * 请假人id
     */
    private Long userid;
    /**
     * 请假原因
     */
    private String content;

    /**
     * 请假天数
     */
    private Long num;
    /**
     * 请假状态
     *  0-已申请
     *  1-已审核
     *  2-退回
     */
    private Long status;
    /**
     * 审核人id
     */
    private Long auditid;

    private User leaveUser;
    private User auditUser;

    /**
     * 创建时间 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date auditTime;

    /**
     * 审核意见
     */
    private String auditInfo;



}
