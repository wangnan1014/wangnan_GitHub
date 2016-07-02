package com.heag.rcpc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.heag.rcpc.model.PcEvaluateRelation;
import com.heag.rcpc.model.PcEvaluateRelationExample;
import com.heag.rcpc.model.PcSendInvitations;

public interface IPcEvaluateRelationDao {
	
    /**
     * 根据条件查询所有评估关系信息
     * @param PcEvaluateRelationExample
     * @return 成功  ArrayList<PcEvaluateRelation>  
     */
    public ArrayList<PcEvaluateRelation> selectByExample(PcEvaluateRelationExample pae);
    
    /**
     * 根据id更新评估关系信息(删除多个数据)
     * @param id
     * @return   int
     */  
	public int updateByExampleSelective(PcEvaluateRelation per,PcEvaluateRelationExample pere);
	
	
	/**
     * 根据id更新评估关系信息（更新单个数据）
     * @param id
     * @return   int
     */  
	public int updateByPrimaryKeySelective(PcEvaluateRelation per);
    /**
     * 新增评估关系信息
     * @param PcEvaluateRelation
     * @return   
     */
    public String insertSelective(PcEvaluateRelation pa);  
    /**
     * 根据id 查询评估关系信息
     * @param id
     * @return   PcEvaluateRelation
     */
    public PcEvaluateRelation selectByPrimaryKey(Integer id);  
    /**
     * 根据条件查询评估关系信息数
     * @param PcEvaluateRelationExample
     * @return   Integer
     */    
    public Integer countByExample(PcEvaluateRelationExample pae);
    /**
     * 根据id 删除评估关系信息
     * @param id
     * @return   PcAskinfo
     */   
    public String deleteByPrimaryKey(Integer id);
    /**
     * 根据id更新评估关系信息
     * @param id
     * @return   String
     */   
    public String updateByPrimaryKey(PcEvaluateRelation pa);

    /**
     * 根据aid获取评估关系信息
     * @param aid
     * @return   String
     */
    public List<Map<String, String>> selectEvaluateAndEvaluateRelationByAid(Integer aid);

	public ArrayList<PcEvaluateRelation> selectEname(
			PcEvaluateRelationExample pre);
 
	 

}
