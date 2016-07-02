package com.heag.rcpc.service;

import java.util.ArrayList;

import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpDepartmentExample;

public interface IRpDepartmentService {
    /**
     * 查询 所有部门
     * @
     * @return 成功  ArrayList<RpDepartment>  
     */
    public ArrayList<RpDepartment> select();
    public ArrayList<RpDepartment> selectByExample(RpDepartmentExample rde);    
}
