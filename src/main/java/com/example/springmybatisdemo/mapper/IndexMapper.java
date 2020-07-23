package com.example.springmybatisdemo.mapper;

import com.example.springmybatisdemo.domain.ViewBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IndexMapper {
    String SQL = "delete from LF_HIS_96LC_AI where busid = #{busId} and ymd between #{startYmd} and #{endYmd} and isnew = #{isNewValue}";
    @Delete(SQL)
    boolean delete(ViewBean bean);
}
