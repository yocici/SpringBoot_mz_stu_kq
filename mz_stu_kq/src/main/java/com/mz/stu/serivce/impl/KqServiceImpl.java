package com.mz.stu.serivce.impl;

import com.mz.stu.entity.Kq;
import com.mz.stu.entity.User;
import com.mz.stu.mapper.KqMapper;
import com.mz.stu.query.KqQuery;
import com.mz.stu.serivce.IKqService;
import com.mz.stu.util.CommonUtils;
import com.mz.stu.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author: soulcoder-码仔项目库分享圈
 * @qq: 交流咨询 qq2579692606
 * @datetime: 2020/7/1 15:00
 */
@Service
public class KqServiceImpl implements IKqService {

    @Autowired
    private KqMapper kqMapper;

    @Override
    public List<Kq> queryAll() {
        return kqMapper.queryAll();
    }

    @Override
    public PageList listpage(KqQuery kqQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = kqMapper.queryTotal(kqQuery);
        List<Kq> users = kqMapper.queryData(kqQuery);
        pageList.setTotal(total);
        pageList.setRows(users);
        //分页查询的数据
        return pageList;
    }

    //上课考勤
    @Override
    public void upKq() {
        User loginUser = CommonUtils.getLoginUser();
        Kq kq = new Kq();
        kq.setUpClassTime(new Date());
        kq.setUserid(loginUser.getId());
        kq.setCurrentTime(new Date());
        kq.setTid(loginUser.getTid());
        kqMapper.upKq(kq);
    }

    @Override
    public void downKq() {
        User loginUser = CommonUtils.getLoginUser();
        Kq kq = new Kq();
        kq.setDownClassTime(new Date());
        kq.setUserid(loginUser.getId());
        kq.setCurrentTime(new Date());
        kq.setTid(loginUser.getTid());
        kqMapper.downKq(kq);
    }

    /**
     * 判断是否已经上课打卡
     * @return
     */
    @Override
    public boolean isUpKq() {
        Kq kq = new Kq();
        kq.setUserid(     CommonUtils.getLoginUser().getId());
        kq.setCurrentTime(new Date());

       Kq kqRecored =  kqMapper.queryRecoredByUserid(kq);
       if(kqRecored==null){
           return false;
       }
        return true;
    }

    @Override
    public boolean isDownKq() {
        Kq kq = new Kq();
        kq.setUserid(     CommonUtils.getLoginUser().getId());
        kq.setCurrentTime(new Date());

        Kq kqRecored =  kqMapper.queryDownRecoredByUserid(kq);
        if(kqRecored==null){
            return false;
        }
        return true;
    }


}
