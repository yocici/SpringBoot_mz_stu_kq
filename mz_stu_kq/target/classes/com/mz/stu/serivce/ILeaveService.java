package com.mz.stu.serivce;



import com.mz.stu.entity.Classes;
import com.mz.stu.entity.Leave;
import com.mz.stu.query.ClassesQuery;
import com.mz.stu.query.LeaveQuery;
import com.mz.stu.util.PageList;

import java.util.List;

/**
 * @description: ILeaveService
 */
public interface ILeaveService {

    /**
     *  查询所有的请假记录
     */
    List<Leave> queryAll();
    /**
     *  分页查询
     */
    PageList listpage(LeaveQuery leaveQuery);

    /**
     * 保存请假记录
     */
    void saveLeave(Leave leave);

    /**
     * 批量审批
     * @param ids
     */
    void auditLeaveRecord(Long[] ids,String auditinfo);

    /**
     * 批量驳回
     * @param ids
     * @param auditinfo
     */
    void backLeaveRecord(Long[] ids, String auditinfo);
}
