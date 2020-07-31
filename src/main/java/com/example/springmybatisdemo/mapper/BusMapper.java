package com.example.springmybatisdemo.mapper;

import com.example.springmybatisdemo.domain.BusBean;
import com.example.springmybatisdemo.domain.StationBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusMapper {

    @Select("select BUSID,NAME,STATIONID from BASE_BUS where STATIONID = #{stationId} and FORECASTFLAG = 1 order by NAME")
    @Results({
            @Result(property = "busId",column = "busId"),
            @Result(property = "busName",column = "name"),
            @Result(property = "stationId",column = "stationId")
    })
    List<BusBean> getBeansFromStationId(StationBean bean);
}
