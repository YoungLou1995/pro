package com.cernet.pro.mapper;

import com.cernet.pro.model.App2App;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface App2AppMapper {

    @Select("select * from APP2APP")
    List<App2App> list();
}
