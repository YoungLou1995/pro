package com.cernet.pro.model;

import lombok.Data;

@Data
public class Actions {
    private Integer id;
    private String sourceIP;
    private String destIP;
    private Integer sourcePort;
    private Integer destPort;
    private String protocol;
    private Double packageSize;
    private Long gmtTimeStamp;
    private String cls;
}

