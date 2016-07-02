package com.heag.rcpc.dao;

import java.util.ArrayList;

import com.heag.rcpc.model.RpCompanyExample;
import com.heag.rcpc.model.RpCompany;;


/**
 * Created by Administrator on 2015-6-24 0016.
 */
public interface IRpCompanyDao {
    /**
     * 查询所有公司 
     * @param RpRole
     * @return 成功  ArrayList<RpRole>  
     */
    public ArrayList<RpCompany> select(RpCompanyExample re);
    public ArrayList<RpCompany> selectByExample(RpCompanyExample re);
    
} 
