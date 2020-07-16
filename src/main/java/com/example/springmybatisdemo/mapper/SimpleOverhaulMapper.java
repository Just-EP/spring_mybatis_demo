package com.example.springmybatisdemo.mapper;

import com.example.springmybatisdemo.domain.SimpleOverhaulBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 12392
 */
@Mapper
@Repository
public interface SimpleOverhaulMapper {
    /**
     * 获得beans
     * @return result
     * */
//    @Select("select OVERHAUL_NUMBER,WAY_OPINION,FUJIAN,FDFSJZYSX from BUS_OVERHAUL_INFO")
    @Select("select OVERHAUL_NUMBER,APPROVE_STARTDATE,APPROVE_ENDDATE,WAY_OPINION,FUJIAN from BUS_OVERHAUL_INFO where APPROVE_STARTDATE >= '2020-06-01' and APPROVE_STARTDATE <= '2020-06-30'")
//    @Select("select OVERHAUL_NUMBER,APPROVE_STARTDATE,APPROVE_ENDDATE,WAY_OPINION,FUJIAN from BUS_OVERHAUL_INFO where WAY_OPINION like '%合上%开关%' or FUJIAN like '%合上%开关%'")
//    @Select("select OVERHAUL_NUMBER,APPROVE_STARTDATE,APPROVE_ENDDATE,WAY_OPINION,FUJIAN from BUS_OVERHAUL_INFO where WAY_OPINION like '%线供%母线带%线%' or FUJIAN like '%线供%母线带%线%'")
//    @Select("select OVERHAUL_NUMBER,APPROVE_STARTDATE,APPROVE_ENDDATE,WAY_OPINION,FUJIAN from BUS_OVERHAUL_INFO ")
    @Results({
            @Result(property = "overhaulNumber",column = "overhaul_number"),
            @Result(property = "wayOpinion",column = "way_opinion"),
            @Result(property = "startDate",column = "APPROVE_STARTDATE"),
            @Result(property = "endDate",column = "APPROVE_ENDDATE"),
            @Result(property = "fuJian",column = "fuJian"),
            @Result(property = "fdfsjzysx",column = "fdfsjzysx")
    })
    List<SimpleOverhaulBean> getBeans();
}
