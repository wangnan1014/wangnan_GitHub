package com.heag.rcpc.mapper;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcAskinfoExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PcAskinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int countByExample(PcAskinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int deleteByExample(PcAskinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int insert(PcAskinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int insertSelective(PcAskinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    List<PcAskinfo> selectByExample(PcAskinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    PcAskinfo selectByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PcAskinfo record, @Param("example") PcAskinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PcAskinfo record, @Param("example") PcAskinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PcAskinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PcAskinfo record);
    
    List<PcAskinfo> getAskinfoAndQuestionAndOption(PcAskinfo record);
    List<Map<String, String>> getCollectDate(@Param("record") Map<String,Integer> record);
}