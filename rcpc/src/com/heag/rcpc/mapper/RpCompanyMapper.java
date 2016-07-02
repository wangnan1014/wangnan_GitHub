package com.heag.rcpc.mapper;

import com.heag.rcpc.model.RpCompany;
import com.heag.rcpc.model.RpCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpCompanyMapper {
    int countByExample(RpCompanyExample example);

    int deleteByExample(RpCompanyExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(RpCompany record);

    int insertSelective(RpCompany record);

    List<RpCompany> selectByExample(RpCompanyExample example);

    RpCompany selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") RpCompany record, @Param("example") RpCompanyExample example);

    int updateByExample(@Param("record") RpCompany record, @Param("example") RpCompanyExample example);

    int updateByPrimaryKeySelective(RpCompany record);

    int updateByPrimaryKey(RpCompany record);

    int selectLastInsertId();
}