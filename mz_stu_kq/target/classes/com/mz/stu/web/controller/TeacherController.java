package com.mz.stu.web.controller;


import com.mz.stu.entity.User;
import com.mz.stu.query.UserQuery;
import com.mz.stu.serivce.IUserService;

import com.mz.stu.util.MzResult;
import com.mz.stu.util.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(tags = "教师管理接口")
public class TeacherController {

    @Autowired
    private IUserService userService;

    /**
     * 老师列表
     */
    @RequestMapping("/teacher/index")
    public String index(Model model){
        //用户首页
        return "views/teacher/teacher_list";
    }

    @RequestMapping("/teacher/listpage")
    @ResponseBody
    public PageList listpage(UserQuery userQuery){
        System.out.println("传递参数:"+userQuery);
        userQuery.setType(2L);//2表示老师
        return  userService.listpage(userQuery);
    }

    //修改用户editSaveUser
    @PostMapping("/teacher/editSaveStu")
    @ApiOperation("修改用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "User", value = "修改用户对象")
    })
    @PreAuthorize("hasRole('管理员')")
    @ResponseBody
    public MzResult editSaveStu(User user){
        try {
            userService.editSaveUser(user);
            return new MzResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MzResult("修改失败");
    }


}
