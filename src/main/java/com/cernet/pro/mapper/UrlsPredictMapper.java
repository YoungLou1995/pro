package com.cernet.pro.mapper;

import com.cernet.pro.model.UrlAppName;
import com.cernet.pro.model.UrlsPredict;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrlsPredictMapper {

    @Select("select * from URLSPREDICT")
    List<UrlsPredict> list();

    @Insert("insert into URLSPREDICT (url, cls, appname, type, systemtime, ipv) values(#{url}, #{cls}, #{appName}, #{type}, #{systemTime}, #{IPV})")
    void insert(UrlsPredict urlsPredict);

}
