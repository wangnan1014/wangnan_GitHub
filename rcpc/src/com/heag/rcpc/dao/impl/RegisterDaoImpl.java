package com.heag.rcpc.dao.impl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.heag.rcpc.dao.RegisterDao;
import com.heag.rcpc.mapper.RpUserMapper;
import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.util.ApplicationUtil;
import com.heag.rcpc.util.DateUtil;
import com.heag.rcpc.util.EncryptUtil;
 
/**
 * Created by Administrator on 2015-6-23 0023.
 * 注册dao实现类
 */
public class RegisterDaoImpl extends SqlSessionDaoSupport implements RegisterDao {
	@Autowired
	private RpUserMapper rpUserMapper;   
    public int insert(String uname, String password) throws DataAccessException{
		// TODO Auto-generated method stub 	
		RpUser rser = new RpUser();
		rser.setUname(uname);
		EncryptUtil eu = new EncryptUtil();
		rser.setPassword(eu.encrypt(password ,"20101217190036"));
		//rser.setPassword(password);
		rser.setIsdelete(new Integer(0).byteValue());
		rser.setCreatedate(new Date());
		int  result = rpUserMapper.insertSelective(rser);
		return result;
	}
	public int update(int uid, String password) {
		// TODO Auto-generated method stub
		RpUser rser = new RpUser();
		rser.setUid(uid);
		//rser.setPassword(password);
		EncryptUtil eu = new EncryptUtil();
		rser.setPassword(eu.encrypt(password ,"20101217190036"));
		rpUserMapper.updateByPrimaryKeySelective(rser);
		return 0;
	}
	
	public RpUser select(String uname) throws DataAccessException{
		// TODO Auto-generated method stub
		RpUser rser = new RpUser(); 
		
		rser = rpUserMapper.selectByUname(uname);
		//RpUserMapper.countByExample();
		return rser;
	}
	public int insertByRpUser(RpUser rpUser) {
		// TODO Auto-generated method stub
		int  result = rpUserMapper.insertSelective(rpUser);
		return result;
	}

}
