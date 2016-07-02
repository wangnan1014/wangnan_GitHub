package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpProduct;
import com.heag.rcpc.model.RpProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpProductMapper {
    int countByExample(RpProductExample example);

    int deleteByExample(RpProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(RpProduct record);

    int insertSelective(RpProduct record);

    List<RpProduct> selectByExample(RpProductExample example);

    RpProduct selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") RpProduct record, @Param("example") RpProductExample example);

    int updateByExample(@Param("record") RpProduct record, @Param("example") RpProductExample example);

    int updateByPrimaryKeySelective(RpProduct record);

    int updateByPrimaryKey(RpProduct record);
}