package com.tywho.dao;

import com.tywho.bean.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lty on 2017/12/28/0028.
 */
public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}