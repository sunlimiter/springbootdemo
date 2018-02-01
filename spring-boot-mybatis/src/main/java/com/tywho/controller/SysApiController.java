package com.tywho.controller;

import com.tywho.entity.SysApi;
import com.tywho.service.SysApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lty on 2018/2/1/0001.
 */
@RestController
@RequestMapping("/api")
public class SysApiController {
    @Autowired
    private SysApiService sysApiService;

    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public SysApi findOneCity(@RequestParam(value = "id", required = true) long id) {
        return sysApiService.selectById(id);
    }
}
