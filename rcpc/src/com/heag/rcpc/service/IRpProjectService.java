package com.heag.rcpc.service;

import java.util.ArrayList;
import java.util.Map;

import com.heag.rcpc.model.RpLogExample;
import com.heag.rcpc.model.RpProject;
import com.heag.rcpc.model.RpProjectExample;
import com.heag.rcpc.model.RpRole;
import com.heag.rcpc.model.RpUser;

/*
 * Created by 2016.6.30
 * 
 * */
public interface IRpProjectService {
    /**
     * 查询 项目list
     * @param RpProject
     * @return 成功  ArrayList<RpRole>  
     */
    public ArrayList<RpProject> selectByExample(RpProjectExample rpe);
    
    /**
     * 查询 一个项目
     * @param pid
     * @return 成功  RpProject 
     */    
    
    public RpProject selectByPrimaryKey(int pid);
    /**
     * 删除记录 (可多条)
     * @param RpProjectExample
     * @return 成功
     */
    public int deleteByList(RpProjectExample rpe);  
    
    /**
     * 添加一条记录 
     * @param RpProject
     * @return 成功
     */
    public int insertSelective(RpProject rpProject);     
    
    /**
     * 更新一条记录 
     * @param RpProject
     * @return 成功
     */   
    public int updateByPrimaryKeySelective(RpProject rpProject);
    
    /**
     * 查询 MapReport 
     * @param para
     * @return ArrayList<Map>
     */ 
    public ArrayList<Map> selectProjectMapReport(Map map);
    /**
     * 查总数
     * */
    public int countByExample(RpProjectExample rpe);
}
