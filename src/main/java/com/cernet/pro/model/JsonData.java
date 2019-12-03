package com.cernet.pro.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class JsonData {

    private List<Integer> appCount; // from table actionsPredict
    private Integer benignCount; // from table urlsPredict
    private Integer maliciousCount; // from table urlsPredict
    private List<Integer> actionCount; // from table actionsPredict
    private List<JsonUrl> jsonUrl; // from table urlsPredict
    private List<ActionsPredict> actionsPredict; // from table actionsPredict

    public void setAppCountValue(Integer qqNum, Integer wechatNum, Integer weiboNum, Integer wyemailNum) {

        appCount = new ArrayList<>();
        appCount.add(qqNum);
        appCount.add(wechatNum);
        appCount.add(weiboNum);
        appCount.add(wyemailNum);
    }

    public void setActionCountValue(Integer qqSendMessage, Integer qqSendSpeach, Integer qqSendPhoto, Integer wechatSendMessage, Integer wechatSendSpeech, Integer wechatSendPhoto, Integer weiboPost, Integer weiboLike, Integer weiboComment, Integer wangyiemailSend, Integer wangyiemailReceive) {
        actionCount = new ArrayList<>();
        actionCount.add(qqSendMessage);
        actionCount.add(qqSendSpeach);
        actionCount.add(qqSendPhoto);
        actionCount.add(wechatSendMessage);
        actionCount.add(wechatSendSpeech);
        actionCount.add(wechatSendPhoto);
        actionCount.add(weiboPost);
        actionCount.add(weiboLike);
        actionCount.add(weiboComment);
        actionCount.add(wangyiemailSend);
        actionCount.add(wangyiemailReceive);
    }

    public void setJsonUrlValue(List<JsonUrl> jsonUrlList) {
        jsonUrl = jsonUrlList;
    }

    public void setActionsPredictValue(List<ActionsPredict> actionsPredictList){
        actionsPredict = actionsPredictList;
    }
}

