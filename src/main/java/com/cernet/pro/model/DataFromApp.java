package com.cernet.pro.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "DATAFROMAPP")
@Data
public class DataFromApp {
    @Column(name = "SRCIP")
    private String srcIP;

    @Column(name = "DESTIP")
    private String destIP;

    @Column(name = "SRCPORT")
    private Integer srcPort;

    @Column(name = "DESTPORT")
    private Integer destPort;

    @Column(name = "UID")
    private Integer uid;

    @Column(name = "LENGTH")
    private Integer length;

    @Column(name = "HASURL")
    private Boolean hasUrl;

    @Column(name = "URL")
    private String url;

    @Column(name = "URLMETHOD")
    private String urlMethod;

    @Column(name = "TIMESTAMP")
    private Long timeStamp;

    @Column(name = "APPNAME")
    private String appName;

    @Column(name = "SYSTEMTIME")
    private String systemTime;

    @Column(name = "IPV")
    private Boolean IPV;
}
