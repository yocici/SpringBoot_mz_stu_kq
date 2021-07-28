package com.mz.stu.web.controller;

import com.mz.stu.entity.Menu;
import com.mz.stu.serivce.IMenuService;
import com.mz.stu.util.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/25 11:58
 * @Email: 2579692606@qq.com
 */
@Controller
public class MenuController {

    @Autowired
    private IMenuService menuService;


    @RequestMapping("/menu/index")
    public String index(Model model){
        List<Menu> menus = menuService.queryAllMenu();
        model.addAttribute("menus",menus);
        //返回菜单页面
        return "views/menu/menu_list";
    }

    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/menu/addTopMenu")
    @ResponseBody
    public MzResult addTopMenu(@RequestBody Menu menu){
        MzResult mzResult = new MzResult();
        try{
            menuService.addTopMenu(menu);
            return mzResult;
        }catch(Exception e){
            e.printStackTrace();
            return new MzResult("保存失败");
        }
    }

    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/menu/addSubMenu")
    @ResponseBody
    public MzResult addSubMenu(@RequestBody Menu menu){
        MzResult mzResult = new MzResult();
        try{
            menuService.addSubMenu(menu);
            return mzResult;
        }catch(Exception e){
            e.printStackTrace();
            return new MzResult("保存失败");
        }
    }

    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/menu/deleteMenu")
    @ResponseBody
    public MzResult deleteMenu(Long id){
        MzResult ajaxResult = new MzResult();
        try{
            //删除菜单 通过id删除
            menuService.deleteMenuById(id);
            return ajaxResult;
        }catch(Exception e){
            e.printStackTrace();
            return new MzResult("保存失败");
        }
    }

    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/menu/editMenu")
    @ResponseBody
    public MzResult editMenu(@RequestBody Menu menu){
        MzResult mzResult = new MzResult();
        try{
            menuService.editMenu(menu);
            return mzResult;
        }catch(Exception e){
            e.printStackTrace();
            return new MzResult("保存失败");
        }
    }
}
