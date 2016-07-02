package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpIndustry;
import com.heag.rcpc.model.RpIndustryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpIndustryMapper {
    int countByExample(RpIndustryExample example);

    int deleteByExample(RpIndustryExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(RpIndustry record);

    int insertSelective(RpIndustry record);

    List<RpIndustry> selectByExample(RpIndustryExample example);

    RpIndustry selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") RpIndustry record, @Param("example") RpIndustryExample example);

    int updateByExample(@Param("record") RpIndustry record, @Param("example") RpIndustryExample example);

    int updateByPrimaryKeySelective(RpIndustry record);

    int updateByPrimaryKey(RpIndustry record);
}