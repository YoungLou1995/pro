package com.cernet.pro.model;

import lombok.Data;

@Data
public class ActionsPredict {
    private String actionName;
    private Long timeStamp;
    private String appName;
    private String systemTime;
}
