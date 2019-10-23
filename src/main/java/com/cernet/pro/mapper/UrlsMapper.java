package com.cernet.pro.mapper;

import com.cernet.pro.model.Url2show;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UrlsMapper {
    @Select("select url, appName from urls")
    List<Url2show> list();
}
