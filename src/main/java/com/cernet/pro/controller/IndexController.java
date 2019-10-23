package com.cernet.pro.controller;

import com.cernet.pro.mapper.ActionsMapper;
import com.cernet.pro.model.Actions2show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ActionsMapper actionsMapper;


    @GetMapping("/")
    public String index(Model model){
         List<Actions2show> actions2showList = actionsMapper.list();
         model.addAttribute("action2showList", actions2showList);
        return "index";
    }
}
