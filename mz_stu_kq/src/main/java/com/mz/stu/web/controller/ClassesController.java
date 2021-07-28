package com.mz.stu.web.controller;


import com.mz.stu.entity.Classes;
import com.mz.stu.query.ClassesQuery;

import com.mz.stu.serivce.IClassesService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.MzResult;
import com.mz.stu.util.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "班级管理接口")
public class ClassesController {
    @Autowired
    private IClassesService classesService;


    @GetMapping("/classes/index")
    @ApiOperation("跳转班级页接口")
    public String index(){
        return "views/classes/classes_list";
    }

    @GetMapping("/classes/listpage")
    @ApiOperation("查询班级分页数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ClassesQuery", value = "班级查询对象", defaultValue = "classesQuery对象")
    })
    @ResponseBody
    public PageList listpage(ClassesQuery classesQuery){
        //只能查询自己新增的班级
        Integer type = CommonUtils.getLoginUser().getType();
        if(type == 2){
            classesQuery.setTid(CommonUtils.getLoginUser().getId());
        }
        return  classesService.listpage(classesQuery);
    }


    @PostMapping("/classes/addClasses")
    @ApiOperation("添加班级接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Classes", value = "班级对象")
    })
    @PreAuthorize("hasRole('管理员') || hasRole('老师权限')")
    @ResponseBody
    public MzResult addClasses(Classes classes){
        try {
            classesService.addClasses(classes);
            return new MzResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MzResult("添加失败");
    }


    /**
     *   修改班级editSaveClasses
     */
    @RequestMapping("/classes/editClasses")
    @PreAuthorize("hasRole('管理员') || hasRole('老师权限')")
    @ResponseBody
    public MzResult editClasses(Classes classes){
        try {
            classesService.editSaveClasses(classes);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    /**
     * 根据id去删除班级
     * @param id
     * @return
     */
    @RequestMapping("/classes/deleteClasses/{id}")
    @PreAuthorize("hasRole('管理员') || hasRole('老师权限')")
    @ResponseBody
    public MzResult deleteClasses(@PathVariable("id") Long id){
        try {
            classesService.deleteClasses(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }


    /**
     * 批量删除数据
     * @param ids  [11,22]
     * @return
     */
    @RequestMapping("/classes/deleteBatchClasses")
    @ResponseBody
    public MzResult deleteBatchClasses(@RequestParam("ids[]") Long[] ids){
        try {
            classesService.deleteBatchClasses(ids);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }


}
