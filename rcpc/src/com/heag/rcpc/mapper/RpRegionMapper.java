package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpRegion;
import com.heag.rcpc.model.RpRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpRegionMapper {
    int countByExample(RpRegionExample example);

    int deleteByExample(RpRegionExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(RpRegion record);

    int insertSelective(RpRegion record);

    List<RpRegion> selectByExample(RpRegionExample example);

    RpRegion selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") RpRegion record, @Param("example") RpRegionExample example);

    int updateByExample(@Param("record") RpRegion record, @Param("example") RpRegionExample example);

    int updateByPrimaryKeySelective(RpRegion record);

    int updateByPrimaryKey(RpRegion record);
}