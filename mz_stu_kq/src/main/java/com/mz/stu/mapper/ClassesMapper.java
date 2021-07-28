package com.mz.stu.mapper;

import com.mz.stu.entity.Classes;
import com.mz.stu.query.ClassesQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: soulcoder
 * @datetime: 2020/7/1 8:34
 * @description: 班级Mapper
 */
@Mapper
public interface ClassesMapper {
    /**
     *  查询所有用户
     */
    @Select("select * from t_classes")
    List<Classes> queryAll();

    /**
     *  查询总的条数
     */
    Long queryTotal(ClassesQuery userQuery);
    /**
     *  分页查询数据
     */
    List<Classes> queryData(ClassesQuery userQuery);
    /**
     *  添加班级
     */
    void addClasses(Classes classes);
    /**
     *  修改班级
     */
    void editSaveClasses(Classes classes);
    /**
     *  根据id删除班级
     */
    @Delete("delete from t_classes where id=#{id}")
    void deleteClasses(Long id);
    /**
     *  批量删除数据
     */
    void batchRemove(List list);

    /**
     * 根据id查询班级
     * @param id
     * @return
     */
    @Select("select * from t_classes where id=#{id}")
    Classes findOne(Long id);

    /**
     * 批量删除
     * @param ids
     */
    @Delete("<script>" +
            "delete from t_classes where id in" +
            "<foreach collection='array' item='id' open='(' close=')' separator=',' >" +
            "#{id}"+
            "</foreach>"+
            "</script>")
    void deleteBatchClasses(Long[] ids);
}