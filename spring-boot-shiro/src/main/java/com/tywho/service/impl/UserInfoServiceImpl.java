package com.tywho.service.impl;

import com.tywho.bean.UserInfo;
import com.tywho.dao.UserInfoDao;
import com.tywho.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lty on 2017/12/28/0028.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}