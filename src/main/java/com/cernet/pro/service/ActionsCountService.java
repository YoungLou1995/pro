package com.cernet.pro.service;

import com.cernet.pro.dto.ActionsCountDTO;
import com.cernet.pro.mapper.ActionsPredictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionsCountService {

    @Autowired
    private ActionsPredictMapper actionsPredictMapper;

    public ActionsCountDTO count(){
        return null;
    }
}
