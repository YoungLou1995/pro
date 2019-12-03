package com.cernet.pro.mapper;

import com.cernet.pro.model.Url2App;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Url2AppMapper {
    @Select("select * from URL2APP")
    List<Url2App> list();

    @Insert("insert into URL2APP (url, urlmethod, property, propertyNum, uid, appName, systemTime) values(#{url}, #{urlMethod}, #{property},  #{propertyNum}, #{uid}, #{appName}, #{systemTime})")
    void insert(Url2App url2App);

}
