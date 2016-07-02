package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.RpUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
 
public interface RpUserMapper {
    int countByExample(RpUserExample example);

    int deleteByExample(RpUserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(RpUser record);

    int insertSelective(RpUser record);

    List<RpUser> selectByExample(RpUserExample example);

    RpUser selectByPrimaryKey(Integer uid);

    RpUser selectByUname(String uname);
    
    int updateByExampleSelective(@Param("record") RpUser record, @Param("example") RpUserExample example);

    int updateByExample(@Param("record") RpUser record, @Param("example") RpUserExample example);

    int updateByPrimaryKeySelective(RpUser record);

    int updateByPrimaryKey(RpUser record);

    int selectLastInsertId();
    
    int deleteByPrimaryKeyList(RpUserExample example);
}