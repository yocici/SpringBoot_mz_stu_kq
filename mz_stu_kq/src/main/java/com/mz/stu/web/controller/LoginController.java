package com.mz.stu.web.controller;

import com.mz.stu.entity.Menu;
import com.mz.stu.serivce.IMenuService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 10:38
 * @Email: 2579692606@qq.com
 */
@Controller
public class LoginController {

    @Autowired
    private IMenuService menuService;

    //跳转登录页面
    @RequestMapping("/login")
    public String userLogin() {
        return "views/login";
    }
    //登录成功
    @RequestMapping("/index")
    public String index(HttpSession session) {
        System.out.println("登录成功进入");
        if(session == null){
            return "redirect:/toLogin";
        }
        //根据登录用户的角色 确定菜单
        Long userId = CommonUtils.getLoginUser().getId();
        List<Menu> menus = menuService.findAll(userId);
        if (menus != null) {
            session.setAttribute("menuList", menus);
        }
        return "views/index";
    }

    //登录失败
    @RequestMapping("/loginError")
    @ResponseBody
    public MzResult loginError() {
        return new MzResult("用户名或者密码不正确");
    }
}
