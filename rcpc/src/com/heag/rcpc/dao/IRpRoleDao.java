package com.heag.rcpc.dao;

import java.util.ArrayList;

import com.heag.rcpc.model.RpRole;
import com.heag.rcpc.model.RpRoleExample;


public interface IRpRoleDao {
    /**
     * 新增角色
     */
    public int insert(RpRole rpRole );
    /**
     * 更新角色
     * @param rpRole
     * @return 成功  1 或 失败：0
     */
    public int update(RpRole rpRole );
    /**
     * 查询用户  
     * @param RpRole
     * @return 成功  ArrayList<RpRole>  
     */
    public ArrayList<RpRole> select(RpRoleExample re);

}
