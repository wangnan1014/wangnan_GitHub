package com.heag.rcpc.dao;

import java.util.ArrayList;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcAskinfoExample;
import com.heag.rcpc.model.RpCompany;
import com.heag.rcpc.model.RpCompanyExample;

public interface IPcAskinfoDao {
    /**
     * 根据条件查询所有问卷
     * @param PcAskinfoExample
     * @return 成功  ArrayList<>  
     */
    public ArrayList<PcAskinfo> selectByExample(PcAskinfoExample pae);
    /**
     * 新增问卷
     * @param PcAskinfo
     * @return   
     */
    public String insertSelective(PcAskinfo pa);  
    /**
     * 根据aid 查询问卷
     * @param aid
     * @return   PcAskinfo
     */
    public PcAskinfo selectByPrimaryKey(Integer aid);
    /**
     * 根据条件查询问卷数
     * @param PcAskinfoExample
     * @return   Integer
     */    
    public Integer countByExample(PcAskinfoExample pae);
    /**
     * 根据aid 删除问卷
     * @param aid
     * @return   PcAskinfo
     */   
    public String deleteByPrimaryKey(Integer aid);
    /**
     * 根据aid更新问卷
     * @param  PcAskinfo
     * @return  String
     */   
    public String updateByPrimaryKeySelective(PcAskinfo pa);    
    /**
     * 根据aid获取问卷所有信息（问卷、题目、选项）
     * @param  PcAskinfo
     * @return  String
     */   
    public ArrayList<PcAskinfo> getAskinfoAndQuestionAndOption(PcAskinfo pa);
}
