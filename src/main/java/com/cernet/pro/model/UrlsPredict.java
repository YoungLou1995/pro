package com.cernet.pro.model;

import lombok.Data;

@Data
public class UrlsPredict {
    private Integer id;
    private String url;
    private Integer cls;
    private String type;
    private Long timeStamp;
    private String appName;
    private String systemTime;
    private Boolean IPV;
}
