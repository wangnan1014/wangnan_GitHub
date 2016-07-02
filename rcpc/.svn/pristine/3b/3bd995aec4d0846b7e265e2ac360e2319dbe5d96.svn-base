package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpProvince;
import com.heag.rcpc.model.RpProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpProvinceMapper {
    int countByExample(RpProvinceExample example);

    int deleteByExample(RpProvinceExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(RpProvince record);

    int insertSelective(RpProvince record);

    List<RpProvince> selectByExample(RpProvinceExample example);

    RpProvince selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") RpProvince record, @Param("example") RpProvinceExample example);

    int updateByExample(@Param("record") RpProvince record, @Param("example") RpProvinceExample example);

    int updateByPrimaryKeySelective(RpProvince record);

    int updateByPrimaryKey(RpProvince record);
}