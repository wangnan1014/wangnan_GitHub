package com.heag.rcpc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.heag.rcpc.model.RpProject;
import com.heag.rcpc.model.RpProjectExample;

/*
 * Created by 2016.6.30
 * 
 * */
public interface IRpProjectDao {
    /**
     * 查询项目
     * @param RpProjectExample
     * @return 成功  ArrayList<RpProject>  
     */
    public ArrayList<RpProject> selectByExample(RpProjectExample rpe);  
    
    /**
     * 查询一个项目
     * @param pid
     * @return 成功  RpProject  
     */
    public RpProject selectByPrimaryKey(int pid);      
    /**
     * 删除记录 (可多条)
     * @param RpProjectExample
     * @return >0成功
     */
    public int deleteByList(RpProjectExample rpe);
    /**
     * add记录 
     * @param int
     * @return 0 成功
     */
    public int insertSelective(RpProject rpProject);  
    /**
     * edit记录 
     * @param int
     * @return 0 成功
     */
    public int updateByPrimaryKeySelective(RpProject rpProject);      
   
    /**
     * 查询 MapReport 
     * @param map
     * @return List<Map>
     */ 
    public List<Map> selectProjectMapReport(Map map);
    /**
     * 查总数
     * */
    public int countByExample(RpProjectExample rpe);
}
