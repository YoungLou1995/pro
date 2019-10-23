package com.cernet.pro.mapper;

import com.cernet.pro.model.Actions;
import com.cernet.pro.model.Actions2show;
import jnr.ffi.annotations.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActionsMapper {

    @Select("select gmtTimeStamp, cls from actions")
    List<Actions2show> list();

    @Insert("insert into actions (sourceIP, destIP, sourcePort, destPort, protocol, packageSize, gmtTimeStamp) values(#{sourceIP}, #{destIP}, #{sourcePort}, #{destPort}, #{protocol}, #{packageSize}, #{gmtTimeStamp})")
    void insert(Actions actions);

}
