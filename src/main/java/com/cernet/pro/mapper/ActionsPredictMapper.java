package com.cernet.pro.mapper;

import com.cernet.pro.model.ActionsPredict;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActionsPredictMapper {

    @Select("select * from ACTIONSPREDICT")
    List<ActionsPredict> list();


    @Insert("insert into ACTIONSPREDICT (actionName, appName, systemTime) values(#{actionName}, #{appName}, #{systemTime})")
    void insert(ActionsPredict actionsPredict);
}
