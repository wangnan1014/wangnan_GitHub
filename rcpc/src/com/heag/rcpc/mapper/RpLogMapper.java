package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpLog;
import com.heag.rcpc.model.RpLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpLogMapper {
    int countByExample(RpLogExample example);

    int deleteByExample(RpLogExample example);

    int deleteByPrimaryKey(Long lid);
    
    int deleteByPrimaryKeyList(String pidVals);
    
    int insert(RpLog record);

    int insertSelective(RpLog record);

    List<RpLog> selectByExample(RpLogExample example);

    RpLog selectByPrimaryKey(Long lid);

    int updateByExampleSelective(@Param("record") RpLog record, @Param("example") RpLogExample example);

    int updateByExample(@Param("record") RpLog record, @Param("example") RpLogExample example);

    int updateByPrimaryKeySelective(RpLog record);

    int updateByPrimaryKey(RpLog record);

    int selectLastInsertId();
}