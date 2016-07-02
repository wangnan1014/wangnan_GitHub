package com.heag.rcpc.dao;

import java.util.ArrayList;

import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpDepartmentExample;
/**
 * Created by Administrator on 2015-6-26 0016.
 */
public interface IRpDepartmentDao {
    /**
     * 查询所有部门 
     * @param RpRole
     * @return 成功  ArrayList<RpRole>  
     */
    public ArrayList<RpDepartment> select(RpDepartmentExample re);  
    public ArrayList<RpDepartment> selectByExample(RpDepartmentExample re);  

}
