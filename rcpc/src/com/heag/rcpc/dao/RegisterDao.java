package com.heag.rcpc.dao;

import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.WebUser;
 
/**
 * Created by Administrator on 2015-6-23 0016.
 * @author wn
 */

public interface RegisterDao {
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
	
}
