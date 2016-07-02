package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpProject;
import com.heag.rcpc.model.RpProjectExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RpProjectMapper {
    int countByExample(RpProjectExample example);

    int deleteByExample(RpProjectExample example);

    int deleteByPrimaryKey(Integer pid);
    
    int deleteByPrimaryKeyList(RpProjectExample rpe);
    
    int insert(RpProject record);

    int insertSelective(RpProject record);

    List<RpProject> selectByExample(RpProjectExample example);

    RpProject selectByPrimaryKey(Integer pid);
    
    List<Map> selectProjectMapReport(Map map);
    
    List<RpProject> select(RpProjectExample example);  
    
    int updateByExampleSelective(@Param("record") RpProject record, @Param("example") RpProjectExample example);

    int updateByExample(@Param("record") RpProject record, @Param("example") RpProjectExample example);

    int updateByPrimaryKeySelective(RpProject record);

    int updateByPrimaryKey(RpProject record);

}