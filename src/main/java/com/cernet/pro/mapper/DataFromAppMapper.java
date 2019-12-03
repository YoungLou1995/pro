package com.cernet.pro.mapper;

import com.cernet.pro.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataFromAppMapper {

    @Insert("insert into DATAFROMAPP (srcIP, destIP, srcPort, destPort, uid, length, hasUrl, url, urlMethod, timeStamp, appName, systemTime, IPV) values(#{srcIP}, #{destIP},#{srcPort},#{destPort},#{uid},#{length},#{hasUrl},#{url},#{urlMethod},#{timeStamp}, #{appName}, #{systemTime}, #{IPV})")
    void insert(DataFromApp dataFromApp);


    @Select("select * from DATAFROMAPP")
    List<DataFromApp> list();

    @Select("select count(id) from DATAFROMAPP")
    int getCount();


    @Select("select length from DATAFROMAPP where id>#{start} and id<=(#{end})")
    List<Integer> getRangeData(DBIndex dbIndex);

    @Select("select * from DATAFROMAPP where hasurl=True and id>#{start}")
    List<UrlsPredict> UrlPredictList(int start);

    @Select("select appname from DATAFROMAPP where appname is not null and id>#{start}")
    List<ActionsPredict> ActionsPredictList(int start);

    @Select("select url, urlMethod, uid, appName, systemTime from DATAFROMAPP where hasUrl=true")
    List<Url2App> url2AppList();

    @Select("select IFNULL(MAX(id), 0) from DATAFROMAPP")
    int getMaxId();

    @Select("select count(id) from URLLIB where url like #{url}")
    int isOk(String url);
}
