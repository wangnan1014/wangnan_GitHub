package com.heag.rcpc.dao;

import java.util.ArrayList;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcResult;
import com.heag.rcpc.model.PcResultExample;

public interface IPcResultDao {

	/**
	 *  根据条件查询所有 问卷结果
	 * @param PcResultExample
	 * @return 成功  ArrayList<PcResult>  
	 */
	public ArrayList<PcResult> selectByExample(PcResultExample pre);
	
	
	/**
	 * 新增 问卷结果
	 * @param pr
	 * @return String
	 */
	public String insertSelective(PcResult pr); 
	
	
	 /**
     * 根据rid 查询 问卷结果
     * @param rid
     * @return   PcResult
     */
    public PcResult selectByPrimaryKey(Integer rid);
    
    
    /**
     * 根据条件查询 问卷结果 数
     * @param PcResultExample
     * @return   Integer
     */    
    public Integer countByExample(PcResultExample pre);
    
    
    /**
     * 根据rid 删除 问卷结果
     * @param rid
     * @return  String
     */   
    public String deleteByPrimaryKey(Integer rid);
    
    
    /**
     * 根据rid 更新 问卷结果
     * @param  PcResult
     * @return  String
     */   
    public String updateByPrimaryKey(PcResult pr);  
    
    
    /**
     * 根据aid id(评估人)获取问卷答题所有信息（问卷、题目、选项）
     * @param  PcAskinfo
     * @return  ArrayList<PcAskinfo>
     */
	public ArrayList<PcAskinfo> getPersonAnswer(PcResult pr);
}
