package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpDepartmentMapper {
    int countByExample(RpDepartmentExample example);

    int deleteByExample(RpDepartmentExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(RpDepartment record);

    int insertSelective(RpDepartment record);

    List<RpDepartment> selectByExample(RpDepartmentExample example);

    RpDepartment selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") RpDepartment record, @Param("example") RpDepartmentExample example);

    int updateByExample(@Param("record") RpDepartment record, @Param("example") RpDepartmentExample example);

    int updateByPrimaryKeySelective(RpDepartment record);

    int updateByPrimaryKey(RpDepartment record);

    int selectLastInsertId();
}