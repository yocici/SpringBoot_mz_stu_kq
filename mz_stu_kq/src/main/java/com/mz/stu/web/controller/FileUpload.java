package com.mz.stu.web.controller;



import com.mz.stu.entity.User;
import com.mz.stu.serivce.IUserService;
import com.mz.stu.util.MzResult;
import io.swagger.annotations.Api;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUpload {

    @Autowired
    private IUserService userService;

    @Value("${mz.upload.path}")
    private String uploadPath;

    @RequestMapping(value="/file/uploadFile", method= RequestMethod.POST)
    @ResponseBody
    public MzResult upload(HttpServletRequest req, Integer id, @RequestParam("file") MultipartFile file){
        System.out.println("上传文件用户...."+id);
        try {
            if(file.isEmpty()){
                return new MzResult("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String uuidString = UUID.randomUUID().toString();
            String newFileName= uuidString + suffixName;

            File path = new File(uploadPath);
            if (!path.exists()) path.mkdirs();

            File savefile = new File(path,newFileName);
            if (!savefile.getParentFile().exists()) savefile.getParentFile().mkdirs();
            file.transferTo(savefile);

            //更新用户表的头像
            User user = new User();
            user.setId(Long.parseLong(id+""));
            user.setHeadImg(newFileName);
            userService.updateUserHeadImg(user);

            return new MzResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/showimage/{image_name}")
    public String showphoto(@PathVariable("image_name") String image_name,HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        // 获得的系统的根目录
        File fileParent = new File(File.separator);
        // 获得/usr/CBeann目录
        System.out.println("读取头像:"+image_name);
        File file = null ;
        String os = System.getProperty("os.name");
        ServletOutputStream out = response.getOutputStream();
        try {
            if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
                file = new File(uploadPath +"\\"+ image_name);
            } else {  //linux 和mac
                file = new File(fileParent, uploadPath.substring(1) +"/"+ image_name);
            }
            IOUtils.copy(new FileInputStream(file),out);
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

}
