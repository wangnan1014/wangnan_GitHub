package com.heag.rcpc.dao;

import java.util.ArrayList;

import com.heag.rcpc.model.PcOptions;
import com.heag.rcpc.model.PcOptionsExample;

public interface IPcOptionsDao {

	/**
	 *  根据条件查询所有 题目选项信息
	 * @param PcOptionsExample
	 * @return 成功  ArrayList<PcOptions>  
	 */
	public ArrayList<PcOptions> selectByExample(PcOptionsExample poe);
	
	
	/**
	 * 新增题目选项
	 * @param po
	 * @return String
	 */
	public String insertSelective(PcOptions po); 
	
	
	 /**
     * 根据oid 查询题目选项
     * @param oid
     * @return   PcOptions
     */
    public PcOptions selectByPrimaryKey(Integer oid);
    
    
    /**
     * 根据条件查询题目选项数
     * @param PcOptionsExample
     * @return   Integer
     */    
    public Integer countByExample(PcOptionsExample poe);
    
    
    /**
     * 根据oid 删除题目选项
     * @param oid
     * @return  String
     */   
    public String deleteByPrimaryKey(Integer oid);
    
    /**
     * 根据qid条件 更新题目选项
     * @param oid
     * @return  String
     */   
    public String updateByExampleSelective(PcOptions record,PcOptionsExample example);    
    /**
     * 根据oid 更新题目选项
     * @param  PcOptions
     * @return  String
     */   
    public String updateByPrimaryKey(PcOptions po);  
	

}
