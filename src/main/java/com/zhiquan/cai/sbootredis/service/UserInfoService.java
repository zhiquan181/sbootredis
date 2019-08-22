package com.zhiquan.cai.sbootredis.service;

import com.zhiquan.cai.sbootredis.vi.UserInfo;

public interface UserInfoService {

    //新增用户
    public void saveData(String username , String password , int age);

    //根据id获取user
    public UserInfo findById(String id);

}
