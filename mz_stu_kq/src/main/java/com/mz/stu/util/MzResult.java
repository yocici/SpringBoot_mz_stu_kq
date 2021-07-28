package com.mz.stu.util;

import lombok.Data;

import java.util.HashMap;

@Data
public class MzResult extends HashMap {

    public static MzResult ok(){
        return new MzResult();
    }

    public static MzResult error(String msg){
        return new MzResult(msg);
    }

    public MzResult put(String key ,Object value){
        super.put(key,value);
        return this;
    }

    public MzResult() {
        put("isSuccess",true);
        put("message","操作成功");
    }

    public MzResult(String msg){
        put("isSuccess",false);
        put("message",msg);
    }


}