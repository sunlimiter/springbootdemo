package com.tywho.service.impl;

import com.tywho.dao.SysApiDao;
import com.tywho.entity.SysApi;
import com.tywho.service.SysApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lty on 2018/2/1/0001.
 */
@Service
public class SysApiServiceImpl implements SysApiService {
    @Autowired
    private SysApiDao sysApiDao;

    @Override
    public SysApi selectById(long id) {
        return sysApiDao.selectById(id);
    }
}
