package com.mz.stu.serivce.impl;


import com.mz.stu.entity.Leave;
import com.mz.stu.mapper.LeaveMapper;
import com.mz.stu.query.LeaveQuery;
import com.mz.stu.serivce.ILeaveService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: LeaveServiceImpl
 */
@Service
public class LeaveServiceImpl implements ILeaveService {

    @Autowired
    private LeaveMapper leaveMapper;


    @Override
    public List<Leave> queryAll() {
        return leaveMapper.queryAll();
    }

    @Override
    public PageList listpage(LeaveQuery leaveQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = leaveMapper.queryTotal(leaveQuery);
        List<Leave> leaves = leaveMapper.queryData(leaveQuery);
        pageList.setTotal(total);
        pageList.setRows(leaves);
        //分页查询的数据
        return pageList;
    }

    @Override
    public void saveLeave(Leave leave) {
        //设置申请请假时间
        leave.setCreateTime(new Date());
        leave.setUserid(CommonUtils.getLoginUser().getId());
        leave.setStatus(0L);
        leaveMapper.saveLeave(leave);
    }

    /**
     * 批量审核流程
     * @param ids
     */
    @Override
    public void auditLeaveRecord(Long[] ids,String auditinfo) {
        Map mp = new HashMap();
        mp.put("ids",ids);
        mp.put("auditinfo",auditinfo);
        mp.put("auditTime",new Date());
        leaveMapper.auditLeaveRecord(mp);
    }

    @Override
    public void backLeaveRecord(Long[] ids, String auditinfo) {
        Map mp = new HashMap();
        mp.put("ids",ids);
        mp.put("auditinfo",auditinfo);
        mp.put("auditTime",new Date());
        leaveMapper.backLeaveRecord(mp);

    }

}
