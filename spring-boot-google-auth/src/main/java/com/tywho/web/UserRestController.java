package com.tywho.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by lty on 2017/12/29/0029.
 */

@RestController
@RequestMapping("/")
public class UserRestController {

    @RequestMapping(
            value = "user",
            method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }
}