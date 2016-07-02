package com.heag.rcpc.dao;

import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.RpUserExample;
import java.util.List;


public interface IRpUserDao {

    public int insert(RpUser rpUser);
    
    public List<RpUser> selectByExample(RpUserExample example);
    
    public int updateByPrimaryKeySelective(RpUser rpUser);
    
    public RpUser selectByUserName(String username);
    /**
     * 删除用户
     * @param RpUserExample
     * @return int 失败 0
     */
    public int deleteByPrimaryKeyList(RpUserExample example);
    /**
     * 注册用户
     * @param uname,password
     * @return 成功  1 或 失败：0
     */
    public int insert(String uname,String password);
    
    public int insertByRpUser(RpUser rpUser);
    /**
     * 更新密码
     * @param uname,password
     * @return 成功  1 或 失败：0
     */
    public int update(int uid,String password);
    /**
     * 查询用户是否存在 
     * @param uname,password
     * @return 成功 RpUser  
     */
    public RpUser select(String uname);	
    /**
     * 查询用户数
     * @param RpUserExample
     * @return 成功 int  
     */    
    public int countByExample(RpUserExample example);
    /**
     * 查询用户数据
     * @param Integer
     * @return 成功  RpUser  
     */    
	public RpUser selectByPrimaryKey(Integer i);
	
}
