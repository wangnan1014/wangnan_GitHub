package com.heag.rcpc.service;

import java.util.ArrayList;

import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.RpUserExample;
/**
 * Created by Administrator on 2015-6-23 .
 * @author wn
 */
public interface IRpUserService {
	//用户注册
    public int insert(String username,String password);
    //新增用户
    public int insertByRpUser(RpUser rpUser);
    //更新用户密码
    public int update(int uid,String password);
    //更新用户
    public int updateByPrimaryKeySelective(RpUser rpUser);
    //查询用户是否存在
    public RpUser select(String uname) ;
    //删除用户
    public int deleteByPrimaryKeyList(RpUserExample example);
    /**
     * 用户登录
     * @param username
     * @param password
     * @return 成功返回true，失败返回false
     */
    public boolean login(String username,String password);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return 成功返回RpUser，失败返回NULL
     */
    public RpUser loginWithModelRet(String username,String password);
    /**
     * 用户获取
     * @param RpUserExample
     * @return 成功返回 ArrayList<RpUser>
     */    
    public  ArrayList<RpUser> selectByExample(RpUserExample example);
    /**
     * 用户 总数
     * @param RpUserExample
     * @return 成功返回 总数 int
     */  
    public  int countByExample(RpUserExample example);
    /**
     * 用户查询获取
     * @param Integer
     * @return 成功返回 总数 RpProject
     */      
	public RpUser selectByPrimaryKey(Integer i);

}
