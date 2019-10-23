package com.cernet.pro.mapper;

import com.cernet.pro.model.ActionsPredict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActionsPredictMapper {

    @Select("select appname from actionspredict")
    List<ActionsPredict> list();




}
