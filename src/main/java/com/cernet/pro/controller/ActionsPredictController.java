package com.cernet.pro.controller;

import com.cernet.pro.mapper.ActionsPredictMapper;
import com.cernet.pro.model.ActionsPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class ActionsPredictController {

    @Autowired
    private ActionsPredictMapper actionsPredictMapper;



    @GetMapping("getActionsPredict")
    public String getActionsPredict(){
        System.out.println("here!");
        return "actionsPredict";
    }

    @PostMapping("postActionsPredict")
    public String postActionsPredict(@RequestParam("action") String action){

        String appName = "nothing";
        String[] actionList = {"QQ", "微信", "微博", "网易邮箱"};
        if (action!=null){
            for (String a : actionList) {
                if (action.contains(a)){
                    appName = a;
                    break;
                }
            }
        }

        System.out.println(appName);
        System.out.println(action);

        Date time= new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = format.format(time);

        ActionsPredict actionsPredict = new ActionsPredict();

        actionsPredict.setSystemTime(formatTime);
        actionsPredict.setAppName(appName);
        actionsPredict.setActionName(action);

        actionsPredictMapper.insert(actionsPredict);


        return "actionsPredict";

    }
}
