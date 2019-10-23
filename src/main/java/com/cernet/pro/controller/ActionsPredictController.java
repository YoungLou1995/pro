package com.cernet.pro.controller;

import com.cernet.pro.dto.ActionsCountDTO;
import com.cernet.pro.mapper.ActionsPredictMapper;
import com.cernet.pro.mapper.UrlsPredictMapper;
import com.cernet.pro.model.ActionsPredict;
import com.cernet.pro.model.UrlsPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActionsPredictController {

    @Autowired
    private ActionsPredictMapper actionsPredictMapper;

    @Autowired
    private UrlsPredictMapper urlsPredictMapper;

    @GetMapping("actionsPredict")
    public String predict(Model model){

        ActionsCountDTO actionsCountDTO = new ActionsCountDTO();
        List<ActionsPredict>  actionsPredictList = actionsPredictMapper.list();
        actionsCountDTO.setQqNum(0);
        actionsCountDTO.setWechatNum(0);
        actionsCountDTO.setWeiboNum(0);
        actionsCountDTO.setWyemailNum(0);

        for (ActionsPredict actionsPredict : actionsPredictList) {
            if (actionsPredict!=null){
                if (actionsPredict.getAppName().contains("qq")){
                    actionsCountDTO.setQqNum(actionsCountDTO.getQqNum()+1);
                } else if (actionsPredict.getAppName().contains("wechat")){
                    actionsCountDTO.setWechatNum(actionsCountDTO.getWechatNum()+1);
                }else if (actionsPredict.getAppName().contains("weibo")){
                    actionsCountDTO.setWeiboNum(actionsCountDTO.getWeiboNum()+1);
                }else if (actionsPredict.getAppName().contains("wangyi")){
                    actionsCountDTO.setWyemailNum(actionsCountDTO.getWyemailNum()+1);
                }
            }
        }


        List<UrlsPredict> urlsPredictList = urlsPredictMapper.list();

        model.addAttribute("count", actionsCountDTO);
        model.addAttribute("urlsPredictList", urlsPredictList);
        return "actionsPredict";
    }
}
