package com.heag.rcpc.dao;

import com.heag.rcpc.model.WebUser;
import com.heag.rcpc.model.WebUserExample;

import java.util.List;

/**
 * Created by Administrator on 2015-6-16 0016.
 */
public interface IWebUserDao {

    /**
     * 新增一条记录
     * @param user
     * @return 新记录id 或 失败：0
     */
    public int insert(WebUser user);

    /**
     * 按example更新记录
     * @param user
     * @param example
     * @return
     */
    public int updateByExampleSelective(WebUser user,WebUserExample example);

    /**
     * 按example查询记录
     * @param example
     * @return 记录集合
     */
    public List<WebUser> selectByExample(WebUserExample example);

    /**
     * 按主键获取记录
     * @param id
     * @return webuser
     */
    public WebUser getWebUser(Integer id);

}
