package com.cernet.pro.model;

import lombok.Data;

@Data
public class Url2App {

    private String url;
    private String urlMethod;
    private Long timeStamp;
    private Integer property;
    private Float propertyNum;
    private Integer uid;
    private String appName;
    private String systemTime;
}
