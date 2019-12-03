package com.cernet.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {

    @GetMapping("show")
    public String show(){
        return "cernet1";
    }

    @GetMapping("hello")
    public String hello(){return "hello";}
}
