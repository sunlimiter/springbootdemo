package com.tywho.controller;

import com.tywho.bean.SimpleObject;
import com.tywho.utils.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lty on 2018/1/25/0025.
 */
@RestController
@RequestMapping("/hello")
public class UserController {

    @RequestMapping("/test")
    public R hello() {
        return R.ok();
    }

    @RequestMapping("")
    public R hello(@RequestBody SimpleObject simpleObject) {
        System.out.println(simpleObject.getUser());
        return R.ok("请求成功!").put(simpleObject);
    }
}
