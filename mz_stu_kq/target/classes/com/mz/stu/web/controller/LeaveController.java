package com.mz.stu.web.controller;

import com.mz.stu.entity.Leave;
import com.mz.stu.entity.User;
import com.mz.stu.query.KqQuery;
import com.mz.stu.query.LeaveQuery;
import com.mz.stu.serivce.ILeaveService;
import com.mz.stu.serivce.IUserService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.MzResult;
import com.mz.stu.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: LeaveController
 */

@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ILeaveService leaveService;
    /**
     * 学生跳转请假页面
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model){
        User teacher = userService.findOne(CommonUtils.getLoginUser().getTid());
        //查询所有的老师
        model.addAttribute("auditor",teacher);

        return "views/leave/leave_add";
    }

    /**
     * 学生跳转请假记录页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){

        return "views/leave/leave_list";
    }

    /**
     * 学生请假信息 分页显示
     * @return
     */
    @RequestMapping("/listpage")
    @ResponseBody
    public PageList listpage(LeaveQuery leaveQuery){
        leaveQuery.setUserid(CommonUtils.getLoginUser().getId());
        return leaveService.listpage(leaveQuery);
    }




    /**
     * 审核列表
     * @return
     */
    @RequestMapping("/audit")
    public String auditIndex(){

        return "views/leave/leave_audit";
    }

    /**
     * 审核列表
     * @param leaveQuery
     * @return
     */
    @RequestMapping("/auditlistpage")
    @ResponseBody
    public PageList auditlistpage(LeaveQuery leaveQuery){
        //查询审核人是当前登录用户
        leaveQuery.setAuditid(CommonUtils.getLoginUser().getId());
        leaveQuery.setStatus(0L);
        return leaveService.listpage(leaveQuery);
    }

    /**
     * 用户批量批量审核功能
     * auditLeaveRecord
     */
    @RequestMapping("/auditLeaveRecord")
    @ResponseBody
    public MzResult auditLeaveRecord(@RequestParam("ids[]") Long[] ids,String auditinfo){
        try {
            leaveService.auditLeaveRecord(ids,auditinfo);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    /**
     * 批量驳回功能
     * auditLeaveRecord
     */
    @RequestMapping("/backLeaveRecord")
    @ResponseBody
    public MzResult backLeaveRecord(@RequestParam("ids[]") Long[] ids,String auditinfo){
        try {
            leaveService.backLeaveRecord(ids,auditinfo);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    /**
     * 保存请假记录
     * @param leave
     * @return
     */
    @RequestMapping("/addLeave")
    @ResponseBody
    public MzResult addLeave(Leave leave){
        try {
            leaveService.saveLeave(leave);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }


    /**
     * auditlist审批信息
     */
    @RequestMapping("/auditlist")
    public String auditlist(){
        return "views/leave/leave_auditlist";
    }

    /**
     * auditRecordlistpage审批信息分页
     */
    @RequestMapping("/auditRecordlistpage")
    @ResponseBody
    public PageList auditRecordlistpage(LeaveQuery leaveQuery){
        //查询审核人是当前登录用户
        leaveQuery.setAuditid(CommonUtils.getLoginUser().getId());
        leaveQuery.setStatus(3L); //查询 2驳回 和 1审批 信息
        return leaveService.listpage(leaveQuery);
    }



}
