package com.cernet.pro.controller;

import com.alibaba.fastjson.JSON;
import com.cernet.pro.mapper.ActionsPredictMapper;
import com.cernet.pro.mapper.App2AppMapper;
import com.cernet.pro.model.ActionsPredict;
import com.cernet.pro.model.App2App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class App2ppController {
    @Autowired
    private ActionsPredictMapper actionsPredictMapper;

    @GetMapping("/getApp2App")
    @ResponseBody
    public JSON app2app(){
        List<ActionsPredict> list = actionsPredictMapper.list();
        JSON json = (JSON) JSON.toJSON(list);
        return json;

    }
}
