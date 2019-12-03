package com.cernet.pro.mapper;

import com.cernet.pro.model.JsonUrl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JsonUrlMapper {

    @Select("select * from URLSPREDICT")
    List<JsonUrl> list();
}
