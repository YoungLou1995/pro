package com.cernet.pro.controller;

import com.alibaba.fastjson.JSON;
import com.cernet.pro.dto.ActionsCountDTO;
import com.cernet.pro.mapper.ActionsPredictMapper;
import com.cernet.pro.mapper.JsonUrlMapper;
import com.cernet.pro.mapper.UrlsPredictMapper;
import com.cernet.pro.model.ActionsPredict;
import com.cernet.pro.model.JsonData;
import com.cernet.pro.model.JsonUrl;
import com.cernet.pro.model.UrlsPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PredictController {

    @Autowired
    private ActionsPredictMapper actionsPredictMapper;

    @Autowired
    private UrlsPredictMapper urlsPredictMapper;

    @Autowired
    private JsonUrlMapper jsonUrlMapper;


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
                if (actionsPredict.getActionName().contains("qq")){
                    actionsCountDTO.setQqNum(actionsCountDTO.getQqNum()+1);
                } else if (actionsPredict.getActionName().contains("wechat")){
                    actionsCountDTO.setWechatNum(actionsCountDTO.getWechatNum()+1);
                }else if (actionsPredict.getActionName().contains("weibo")){
                    actionsCountDTO.setWeiboNum(actionsCountDTO.getWeiboNum()+1);
                }else if (actionsPredict.getActionName().contains("wangyi")){
                    actionsCountDTO.setWyemailNum(actionsCountDTO.getWyemailNum()+1);
                }
            }
        }


        List<UrlsPredict> urlsPredictList = urlsPredictMapper.list();

        model.addAttribute("count", actionsCountDTO);
        model.addAttribute("urlsPredictList", urlsPredictList);
        return "actionsPredict";
    }

    @GetMapping("getJsonData")
    @ResponseBody
    public JSON JsonData(){

        JsonData jsonData = new JsonData();


        // get ActionCount data
        ActionsCountDTO actionsCountDTO2 = new ActionsCountDTO();
        List<ActionsPredict>  actionsPredictList = actionsPredictMapper.list();
        actionsCountDTO2.setQqNum(0);
        actionsCountDTO2.setWechatNum(0);
        actionsCountDTO2.setWeiboNum(0);
        actionsCountDTO2.setWyemailNum(0);

        for (ActionsPredict actionsPredict : actionsPredictList) {
            if (actionsPredict!=null){
                if (actionsPredict.getActionName().contains("QQ")){
                    actionsCountDTO2.setQqNum(actionsCountDTO2.getQqNum()+1);
                } else if (actionsPredict.getActionName().contains("微信")){
                    actionsCountDTO2.setWechatNum(actionsCountDTO2.getWechatNum()+1);
                }else if (actionsPredict.getActionName().contains("微博")){
                    actionsCountDTO2.setWeiboNum(actionsCountDTO2.getWeiboNum()+1);
                }else if (actionsPredict.getActionName().contains("网易")){
                    actionsCountDTO2.setWyemailNum(actionsCountDTO2.getWyemailNum()+1);
                }
            }
        }


        // get Benign and malicious acount
        List<UrlsPredict> urlsList = urlsPredictMapper.list();
        int countBenign = 0;
        int countMalicious = 0;

        for (UrlsPredict urlsPredict : urlsList) {
            if ("善意".equals(urlsPredict.getType())){
                countBenign++;
            }
            else{
                countMalicious++;
            }
        }

        // get action count data
        int qqSendMessage = 0;
        int qqSendSpeach = 0;
        int qqSendPhoto = 0;
        int wechatSendMessage = 0;
        int wechatSendSpeech = 0;
        int wechatSendPhoto = 0;
        int weiboPost = 0;
        int weiboLike = 0;
        int weiboComment = 0;
        int wangyiemailSend = 0;
        int wangyiemailReceive = 0;

        for (ActionsPredict actionsPredict : actionsPredictList) {
            if (actionsPredict.getActionName().contentEquals("QQ发送文字消息")){
                qqSendMessage++;
            }else if (actionsPredict.getActionName().contentEquals("QQ发送语音消息")){
                qqSendSpeach++;
            }else if (actionsPredict.getActionName().contentEquals("QQ发送图片")){
                qqSendPhoto++;
            }else if (actionsPredict.getActionName().contentEquals("微信发送文字消息")){
                wechatSendMessage++;
            }else if (actionsPredict.getActionName().contentEquals("微信发送语音消息")){
                wechatSendSpeech++;
            }else if (actionsPredict.getActionName().contentEquals("微信发送图片")){
                wechatSendPhoto++;
            } else if (actionsPredict.getActionName().contentEquals("微博上传")){
                weiboPost++;
            }else if (actionsPredict.getActionName().contentEquals("微博点赞")){
                weiboLike++;
            }else if (actionsPredict.getActionName().contentEquals("微博评论")){
                weiboComment++;
            }else if (actionsPredict.getActionName().contentEquals("网易邮箱发送邮件")){
                wangyiemailSend++;
            }else if (actionsPredict.getActionName().contentEquals("网易邮箱打开邮件")){
                wangyiemailReceive++;
            }
        }

        //get jsonUrl

        List<JsonUrl> jsonUrlList = jsonUrlMapper.list();
//        System.out.println(jsonUrlList.toString());

        // get actionsPredict



        jsonData.setBenignCount(countBenign);
        jsonData.setMaliciousCount(countMalicious);
        jsonData.setAppCountValue(actionsCountDTO2.getQqNum(), actionsCountDTO2.getWechatNum(), actionsCountDTO2.getWeiboNum(), actionsCountDTO2.getWyemailNum());
        jsonData.setActionCountValue(qqSendMessage, qqSendSpeach, qqSendPhoto, wechatSendMessage, wechatSendSpeech,
                wechatSendPhoto, weiboPost, weiboLike, weiboComment, wangyiemailSend, wangyiemailReceive);
        jsonData.setJsonUrlValue(jsonUrlList);
        jsonData.setActionsPredictValue(actionsPredictList);

        JSON JsonJsonData = (JSON) JSON.toJSON(jsonData);
        return JsonJsonData;
    }
}
