package com.cernet.pro.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CernetController {

    @GetMapping("cernet")
    public String cernet(){
        return "cernet";
    }
}
