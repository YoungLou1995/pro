package com.cernet.pro.service;

import com.alibaba.fastjson.JSONArray;
import com.cernet.pro.mapper.DataFromAppTKMapper;
import com.cernet.pro.model.DataFromApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class DataFromAppTKService {

    @Autowired
    private DataFromAppTKMapper dataFromAppTKMapper;


    public void insetList(List<DataFromApp> jsonArray) {
        dataFromAppTKMapper.insertList(jsonArray);
    }
}
