package com.mz.stu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: soulcoder
 * @datetime: 2020/7/1 8:34
 * @description: TODO
 */
@Data
public class Classes {
    private Long id;
    private String name;

    private Long tid;

    private User user;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
