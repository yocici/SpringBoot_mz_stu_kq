package com.mz.stu.serivce.impl;


import com.mz.stu.entity.Classes;
import com.mz.stu.mapper.ClassesMapper;
import com.mz.stu.query.ClassesQuery;
import com.mz.stu.serivce.IClassesService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    /**
     * 查询所有的班级
     */
    @Override
    public List<Classes> queryAll() {
        return classesMapper.queryAll();
    }

    @Override
    public PageList listpage(ClassesQuery classesQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = classesMapper.queryTotal(classesQuery);
        List<Classes> users = classesMapper.queryData(classesQuery);
        pageList.setTotal(total);
        pageList.setRows(users);
        //分页查询的数据
        return pageList;
    }

    @Override
    public void addClasses(Classes classes) {
        //设置创建时间
        classes.setCreateTime(new Date());
        classes.setTid(CommonUtils.getLoginUser().getId());
        classesMapper.addClasses(classes);
    }

    @Override
    public void editSaveClasses(Classes classes) {
        classesMapper.editSaveClasses(classes);
    }

    @Override
    public void deleteClasses(Long id) {
        classesMapper.deleteClasses(id);
    }

    @Override
    public void batchRemove(List list) {
        classesMapper.batchRemove(list);
    }

    @Override
    public Classes findOne(Long classesid) {
        return classesMapper.findOne(classesid);
    }

    @Override
    public void deleteBatchClasses(Long[] ids) {
        classesMapper.deleteBatchClasses(ids);
    }
}
