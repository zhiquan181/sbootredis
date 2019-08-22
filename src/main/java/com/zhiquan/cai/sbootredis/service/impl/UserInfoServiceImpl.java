package com.zhiquan.cai.sbootredis.service.impl;

import com.zhiquan.cai.sbootredis.service.UserInfoService;
import com.zhiquan.cai.sbootredis.vi.UserInfo;
import com.zhiquan.cai.sbootredis.vi.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository userRepository;

    //生成UUID
    private String getRandomId()
    {
        String currentDate = (new SimpleDateFormat("yyyyMMddHHmm")).format(new Date());
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        return "ID" + currentDate + uuid;
    }

    //新增用户
    public void saveData(String username , String password , int age){
        UserInfo userInfo = new UserInfo(getRandomId(),username,password,age);
        userRepository.save(userInfo);
    }

    //根据id获取user
    @Override
    public UserInfo findById(String id) {
        return userRepository.findOneById(id);
    }



}
