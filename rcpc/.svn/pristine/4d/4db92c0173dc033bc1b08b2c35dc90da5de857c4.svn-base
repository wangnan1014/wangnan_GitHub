package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpRole;
import com.heag.rcpc.model.RpRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpRoleMapper {
    int countByExample(RpRoleExample example);

    int deleteByExample(RpRoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(RpRole record);

    int insertSelective(RpRole record);

    List<RpRole> selectByExample(RpRoleExample example);

    RpRole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") RpRole record, @Param("example") RpRoleExample example);

    int updateByExample(@Param("record") RpRole record, @Param("example") RpRoleExample example);

    int updateByPrimaryKeySelective(RpRole record);

    int updateByPrimaryKey(RpRole record);

    int selectLastInsertId();
}