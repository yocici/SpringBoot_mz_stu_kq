package com.mz.stu.mapper;

import com.mz.stu.entity.Leave;
import com.mz.stu.query.LeaveQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;

/**
 * @description: LeaveMapper
 */
public interface LeaveMapper {
    @Insert("insert into t_leave(userid,auditid,content,status,createTime,num) " +
            "values(#{userid},#{auditid},#{content},#{status},#{createTime},#{num})")
    void saveLeave(Leave leave);

    List<Leave> queryAll();

    //查询总数
    Long queryTotal(LeaveQuery leaveQuery);

    //分页查询数据
    List<Leave> queryData(LeaveQuery leaveQuery);

    /**
     * 批量审批
     * @param mp
     */
    @Update("<script>" +
            "update  t_leave set auditinfo=#{auditinfo},auditTime=#{auditTime},status=1 where id in" +
            "<foreach collection='ids' item='id' open='(' close=')' separator=',' >" +
            "#{id}"+
            "</foreach>"+
            "</script>")
    void auditLeaveRecord(Map mp);
    /**
     * 批量驳回
     * @param mp
     */
    @Update("<script>" +
            "update  t_leave set auditinfo=#{auditinfo},auditTime=#{auditTime},status=2 where id in" +
            "<foreach collection='ids' item='id' open='(' close=')' separator=',' >" +
            "#{id}"+
            "</foreach>"+
            "</script>")
    void backLeaveRecord(Map mp);
}
