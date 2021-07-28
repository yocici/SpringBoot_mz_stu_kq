package com.mz.stu.query;

import lombok.Data;

@Data
public class LeaveQuery extends BaseQuery {

    private String content;

    private Long userid;

    private Long auditid;

    private Long status;

}
