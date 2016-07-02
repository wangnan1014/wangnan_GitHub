package com.heag.rcpc.dao.impl;

import com.heag.rcpc.dao.IWebUserDao;
import com.heag.rcpc.mapper.WebUserMapper;
import com.heag.rcpc.model.WebUser;
import com.heag.rcpc.model.WebUserExample;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * Created by Administrator on 2015-6-16 0016.
 */
public class WebUserDaoImpl extends SqlSessionDaoSupport implements IWebUserDao {

    //private WebUserMapper mapper=getSqlSession().getMapper(WebUserMapper.class);
    //private final String NAMESPACE="com.heag.rcpc.mapper.WebUserMapper";

    @Autowired
    private WebUserMapper webUserMapper;

    public int insert(final WebUser user) {
//TODO
       if(1==webUserMapper.insertSelective(user)){
           return webUserMapper.selectLastInsertId();
       }else{
           return 0;
       }
      //  return webUserMapper.selectLastInsertId();

    }

    public int updateByExampleSelective(WebUser user, WebUserExample example) {

        return webUserMapper.updateByExampleSelective(user,example);
    }

    public List<WebUser> selectByExample(WebUserExample example) {
        return webUserMapper.selectByExample(example);
    }

    public WebUser getWebUser(Integer id) {
        return webUserMapper.selectByPrimaryKey(id);
    }
}
