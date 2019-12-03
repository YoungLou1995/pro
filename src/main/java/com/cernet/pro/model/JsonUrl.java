package com.cernet.pro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class JsonUrl {

    private String url;
    private Integer cls;
    private String type;
    private String appName;
    private Long timeStamp;
    private String systemTime;
    private Boolean IPV;


}
