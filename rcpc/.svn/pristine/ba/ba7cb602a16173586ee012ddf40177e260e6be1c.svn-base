package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpPermission;
import com.heag.rcpc.model.RpPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpPermissionMapper {
    int countByExample(RpPermissionExample example);

    int deleteByExample(RpPermissionExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(RpPermission record);

    int insertSelective(RpPermission record);

    List<RpPermission> selectByExample(RpPermissionExample example);

    RpPermission selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") RpPermission record, @Param("example") RpPermissionExample example);

    int updateByExample(@Param("record") RpPermission record, @Param("example") RpPermissionExample example);

    int updateByPrimaryKeySelective(RpPermission record);

    int updateByPrimaryKey(RpPermission record);

    int selectLastInsertId();
}