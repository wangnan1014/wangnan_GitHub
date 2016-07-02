package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpRolePermission;
import com.heag.rcpc.model.RpRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpRolePermissionMapper {
    int countByExample(RpRolePermissionExample example);

    int deleteByExample(RpRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RpRolePermission record);

    int insertSelective(RpRolePermission record);

    List<RpRolePermission> selectByExample(RpRolePermissionExample example);

    RpRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RpRolePermission record, @Param("example") RpRolePermissionExample example);

    int updateByExample(@Param("record") RpRolePermission record, @Param("example") RpRolePermissionExample example);

    int updateByPrimaryKeySelective(RpRolePermission record);

    int updateByPrimaryKey(RpRolePermission record);

    int selectLastInsertId();
}