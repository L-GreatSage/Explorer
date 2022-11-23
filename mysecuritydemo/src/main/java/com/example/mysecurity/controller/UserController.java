package com.example.mysecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 11:45
 */

@RestController
public class UserController {

    @GetMapping("/hello")
    public String say(){
        return "hello Security";
    }
}
