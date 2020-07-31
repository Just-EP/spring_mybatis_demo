package com.example.springmybatisdemo.mapper;

import com.example.springmybatisdemo.domain.StationBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StationMapper {
    @Select("select BB.STATIONID,ST_NAME\n" +
            "from BASE_SUBSTATION inner join BASE_BUS BB on BASE_SUBSTATION.STATIONID = BB.STATIONID where bb.FORECASTFLAG = 1 and bb.STATIONID not in (152,170,118,52,138,12,14,25,130,253,113,203,57) group by bb.STATIONID,BASE_SUBSTATION.ST_NAME")
    @Results({
            @Result(property = "stationId",column = "STATIONID"),
            @Result(property = "stationName",column = "ST_NAME"),
    })
    List<StationBean> getBeans();
}
