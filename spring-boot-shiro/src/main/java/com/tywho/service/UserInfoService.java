package com.tywho.service;

import com.tywho.bean.UserInfo;

/**
 * Created by lty on 2017/12/28/0028.
 */
public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}