package com.cernet.pro.controller;

import com.alibaba.fastjson.JSON;
import com.cernet.pro.mapper.Url2AppMapper;
import com.cernet.pro.model.Url2App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Url2AppController {
    @Autowired
    private Url2AppMapper url2AppMapper;

    @GetMapping("/getUrl2App")
    @ResponseBody
    public JSON url2app(){
        List<Url2App> list = url2AppMapper.list();
        JSON json = (JSON) JSON.toJSON(list);
        return json;
    }
}
