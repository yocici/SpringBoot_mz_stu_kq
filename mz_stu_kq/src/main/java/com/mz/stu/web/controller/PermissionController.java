package com.mz.stu.web.controller;

import com.mz.stu.entity.Permission;
import com.mz.stu.serivce.IPermissionService;
import com.mz.stu.util.MzResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  权限维护Controller
 */
@Controller
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/permission/index")
    public String index(Model model){
        List<Permission> allPermisisons = permissionService.findAllPermisisons();
        model.addAttribute("permissions",allPermisisons);
        //返回菜单页面
        return "views/permission/permission_list";
    }

    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/permission/addBtnPermisison")
    @ResponseBody
    public MzResult addBtnPermission(@RequestBody Permission permission){
        MzResult ajaxResult = new MzResult();
        try{
            //{name:xxx,pid:xxx,title:xxx}
            permissionService.addBtnPermisison(permission);
            return ajaxResult;
        }catch(Exception e){
            e.printStackTrace();
            return new MzResult("保存失败");
        }
    }

    //
    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/permission/editBtnPermisison")
    @ResponseBody
    public MzResult editBtnPermisison(@RequestBody Permission permission){
        MzResult ajaxResult = new MzResult();
        try{
            //{name:xxx,pid:xxx,title:xxx}
            permissionService.editBtnPermisison(permission);
            return ajaxResult;
        }catch(Exception e){
            e.printStackTrace();
            return new MzResult("保存失败");
        }
    }

    @PreAuthorize("hasRole('管理员')")
    @RequestMapping("/permission/deletePermisison")
    @ResponseBody
    public MzResult deletePermisison(Long id){
        MzResult ajaxResult = new MzResult();
        try{
            //删除权限 通过权限id
            permissionService.deletePermisisonByPid(id);
            return ajaxResult;
        }catch(Exception e){
            e.printStackTrace();
            return new MzResult("保存失败");
        }
    }
}
