package com.mz.stu.web.controller;


import com.mz.stu.query.KqQuery;
import com.mz.stu.serivce.IKqService;
import com.mz.stu.serivce.IUserService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.MzResult;
import com.mz.stu.util.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "考勤管理接口")
public class KqController {
    @Autowired
    private IKqService kqService;

    @Autowired
    private IUserService userService;


    @GetMapping("/kq/index")
    @ApiOperation("跳转考勤页接口")
    public String index(Model model){
        return "views/kq/kq_list";
    }

    @GetMapping("/kq/listpage")
    @ApiOperation("查询考勤分页数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "KqQuery", value = "考勤查询对象", defaultValue = "kqQuery对象")
    })
    @ResponseBody
    public PageList listpage(KqQuery kqQuery){
        //如果学生用户 只能看到自己的考勤记录 老师可以看到所有记录
        Integer type = CommonUtils.getLoginUser().getType();
        if(type == 3) {
            kqQuery.setUserid(CommonUtils.getLoginUser().getId());
        }
        //如果是老师 ,只能看到自己班上所有的学生
        if(type ==2 ){
            //查询改老师所有的学生 登录老师id
            Long tid = CommonUtils.getLoginUser().getId();
            kqQuery.setTid(tid);
        }
        return  kqService.listpage(kqQuery);
    }

    @PostMapping("/kq/upKq")
    @ApiOperation("上课考勤")
    @ResponseBody
    public MzResult upKq(){
        try {
            //判断是否改学生今天是否已经考勤过
            boolean result =  kqService.isUpKq();
            if(result){
                return new MzResult("已经签到过!");
            }
            kqService.upKq();
            return new MzResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MzResult("考勤失败");
    }

    @PostMapping("/kq/downKq")
    @ApiOperation("下课考勤")
    @ResponseBody
    public MzResult downKq(){
        try {
            boolean result =  kqService.isDownKq();
            if(result){
                return new MzResult("已经签到过!");
            }
            kqService.downKq();
            return new MzResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MzResult("考勤失败");
    }

}
