package com.mz.stu.mapper;

import com.mz.stu.entity.Kq;

/**
 * @description: 考勤Mapper类
 * @author: soulcoder-码仔项目库分享圈
 * @qq: 交流咨询 qq2579692606
 * @datetime: 2020/7/1 14:43
 */
public interface KqMapper extends BaseMapper<Kq> {

    void upKq(Kq kq);

    void downKq(Kq kq);

    /**
     * 查询上课是否已经打过卡
     * @param kq
     * @return
     */
    Kq queryRecoredByUserid(Kq kq);
    /**
     * 查询下课是否已经打过卡
     * @param kq
     * @return
     */
    Kq queryDownRecoredByUserid(Kq kq);
}
