package com.mz.stu.web.controller;

import com.mz.stu.entity.Classes;
import com.mz.stu.entity.Role;
import com.mz.stu.entity.User;
import com.mz.stu.query.UserQuery;
import com.mz.stu.serivce.IClassesService;
import com.mz.stu.serivce.IRoleService;
import com.mz.stu.serivce.IUserService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.MzResult;
import com.mz.stu.util.PageList;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: soulcoder码仔项目分享圈
 * @Decription:
 * @Date: Created on 2020/7/22 14:39
 * @Email: 2579692606@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IClassesService classesService;

    @RequestMapping("/list")
    @ResponseBody
    @PreAuthorize("hasRole('管理员')")
    public List<User> queryAll(){
        return userService.findAll();
    }


    @GetMapping("/info")
    public String info(Model model){
        User loginUser = CommonUtils.getLoginUser();
         Classes classes =  classesService.findOne(loginUser.getClassesid());
         loginUser.setClasses(classes);
        model.addAttribute("loginUser",loginUser);
        //查询用用户满级

        //用户个人
        return "views/user/user_info";
    }


    @GetMapping("/index")
    public String index(String menuid, Model model){
        model.addAttribute("menuid",menuid);
        List<Role> roles = roleService.queryAll();
        model.addAttribute("roles",roles);
        //用户首页
        return "views/user/user_list";
    }

    @GetMapping("/listpage")
    @ResponseBody
    public PageList listpage(UserQuery userQuery){
        return  userService.listpage(userQuery);
    }

    //添加用户
    @PostMapping("/addUser")
    @ResponseBody
    public int addUser(User user){
        userService.addUser(user);
        Integer userid = Integer.parseInt(user.getId()+"");
        //添加成功返回用户id
        return userid;
    }

    @PostMapping("/editSaveUser")
    @ResponseBody
    public MzResult editSaveUser(User user){
        System.out.println("修改用户...."+user);
        try {
            userService.editSaveUser(user);
            return new MzResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MzResult("修改失败");
    }

    //删除用户
    @GetMapping("/deleteUser")
    @ResponseBody
    public MzResult deleteUser(@RequestParam(required = true) Long id){
        MzResult ajaxResult = new MzResult();
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new MzResult("删除失败");
        }

        return ajaxResult;
    }


    @PostMapping("/addUserRole")
    @ApiOperation("添加用户角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramMap", value = "如:{userId:1,[1,2,3,4]]}")
    })
    @ResponseBody
    public MzResult addUserRole(@RequestBody Map paramMap){
        MzResult mzResult = new MzResult();
        String userId = (String)paramMap.get("userId");
        List roleIds = (List) paramMap.get("roleIds");
        System.out.println(userId);
        System.out.println(roleIds);
        try {
            //添加用户对应的角色
            roleService.addUserRole(userId,roleIds);
            return mzResult;
        }catch (Exception e){
            e.printStackTrace();
            return new MzResult("保存角色失败");
        }

    }



    //注册用户
    @RequestMapping("/regSaveUser")
    @ResponseBody
    public Long addTeacher(User user){
        System.out.println("保存用户...."+user);
        userService.addUser(user);
        Long userId = user.getId();
        return userId;
    }

    @PostMapping(value="/deleteBatchUser")
    @ApiOperation("批量用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "如:88,89,99")
    })
    @ResponseBody
    public MzResult deleteBatchUser(String ids){
        String[] idsArr = ids.split(",");
        List list = new ArrayList();
        for(int i=0;i<idsArr.length;i++){
            list.add(idsArr[i]);
        }
        try{
            userService.batchRemove(list);
            return new MzResult();
        }catch(Exception e){
            return new MzResult("批量删除失败");
        }
    }



}
