package com.cernet.pro.mapper;

import com.cernet.pro.model.UrlsPredict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrlsPredictMapper {

    @Select("select * from urlspredict")
    List<UrlsPredict> list();
}
