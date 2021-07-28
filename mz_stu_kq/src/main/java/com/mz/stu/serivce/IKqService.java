package com.mz.stu.serivce;



import com.mz.stu.entity.Kq;
import com.mz.stu.query.KqQuery;
import com.mz.stu.util.PageList;

import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34
 * @qq: 2579692606
 * @description: 考勤记录Service接口层
 */
public interface IKqService {

    //查询考勤记录
    List<Kq> queryAll();
    //分页查询考勤记录
    PageList listpage(KqQuery kqQuery);
    /**
     * 上课打卡
     */
    void upKq();
    /**
     * 下班打卡
     */
    void downKq();

    /**
     * 判断是否已经签到
     * @return
     */
    boolean isUpKq();

    /**
     * 判断下课是否已经签到
     * @return
     */
    boolean isDownKq();
}
