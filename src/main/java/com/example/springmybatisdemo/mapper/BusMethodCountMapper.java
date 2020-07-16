package com.example.springmybatisdemo.mapper;

import com.example.springmybatisdemo.domain.BusMethodCountBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 12392
 */
@Mapper
@Repository
public interface BusMethodCountMapper {
    /**
     * 获取每个母线使用方法及次数
     * @return 结果
     * */
    String QUERY_BEANS_SQL = "select t.BUSID, NAME, METHODID, count from " +
            "(select distinct BUSID,METHODID,count(1) AS count from BUS_STAT_BEST_FC_METHOD group by METHODID,BUSID order by BUSID) t " +
            "inner join BASE_BUS b on t.BUSID = b.BUSID";

    @Select(QUERY_BEANS_SQL)
    @ResultType(BusMethodCountBean.class)
    List<BusMethodCountBean> queryBeans();
}
