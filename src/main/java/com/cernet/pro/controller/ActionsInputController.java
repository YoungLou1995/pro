package com.cernet.pro.controller;

import com.cernet.pro.mapper.ActionsMapper;
import com.cernet.pro.model.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActionsInputController {
    @Autowired
    private ActionsMapper actionsMapper;

    @GetMapping("actionsInput")
    public String action(){
        return "actionsInput";
    }

    @PostMapping("postData")
    public String postData(@RequestParam("sourceIP") String sourceIP,
                           @RequestParam("destIP") String destIP,
                           @RequestParam("sourcePort") Integer sourcePort,
                           @RequestParam("destPort") Integer destPort,
                           @RequestParam("protocol") String protocol,
                           @RequestParam("packageSize") Double packageSize,
                           @RequestParam("gmtTimeStamp") Long gtmTimeStamp){

        Actions actions = new Actions();
        actions.setSourceIP(sourceIP);
        actions.setDestIP(destIP);
        actions.setSourcePort(sourcePort);
        actions.setDestPort(destPort);
        actions.setProtocol(protocol);
        actions.setPackageSize(packageSize);
        actions.setGmtTimeStamp(gtmTimeStamp);

        actionsMapper.insert(actions);
        return "actionsInput";
    }
}
