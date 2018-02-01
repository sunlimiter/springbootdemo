package com.tywho.dao;

import com.tywho.entity.SysApi;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lty on 2018/2/1/0001.
 */
public interface SysApiDao {
    SysApi selectById(@Param("id") long id);
}
