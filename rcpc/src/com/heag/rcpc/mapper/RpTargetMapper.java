package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpTarget;
import com.heag.rcpc.model.RpTargetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpTargetMapper {
    int countByExample(RpTargetExample example);

    int deleteByExample(RpTargetExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(RpTarget record);

    int insertSelective(RpTarget record);

    List<RpTarget> selectByExample(RpTargetExample example);

    RpTarget selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") RpTarget record, @Param("example") RpTargetExample example);

    int updateByExample(@Param("record") RpTarget record, @Param("example") RpTargetExample example);

    int updateByPrimaryKeySelective(RpTarget record);

    int updateByPrimaryKey(RpTarget record);
}