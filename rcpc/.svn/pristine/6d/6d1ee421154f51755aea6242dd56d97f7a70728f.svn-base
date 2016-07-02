package com.heag.rcpc.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;


import com.heag.rcpc.dao.IRpUserDao;
import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.RpUserExample;
import com.heag.rcpc.service.IRpUserService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.EncryptUtil;

public class RpUserServiceImpl implements IRpUserService{
	@Autowired
	private IRpUserDao rpUserDao;
	public int insert(String uname, String password) {
		// TODO Auto-generated method stub
		//RegisterDao rd = (RegisterDao) ApplicationUtil.getBean("registerDao");
		
		int result = 0;
		try {
			result = rpUserDao.insert(uname, password);		
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return result;
	}
	public int update(int uid, String password) {
		// TODO Auto-generated method stub
		//RegisterDao rd = new RegisterDaoImpl();
		//RegisterDao rd = (RegisterDao) ApplicationUtil.getBean("registerDao");
		int result = rpUserDao.update(uid, password);
		return result;
	} 
	public RpUser select(String uname) {
		// TODO Auto-generated method stub
		//RegisterDao rd = new RegisterDaoImpl();
		//RegisterDao rd = (RegisterDao) ApplicationUtil.getBean("registerDao");
		RpUser rpUser = null;
		try {
			rpUser = rpUserDao.select(uname);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return rpUser;
	}
	public int insertByRpUser(RpUser rpUser) {
		// TODO Auto-generated method stub
		//RegisterDao rd = (RegisterDao) ApplicationUtil.getBean("registerDao");
		int result = 0;
		try {
			//String cnames = rpUser.getCname();
			//String deptnames = rpUser.getDeptname();
			//String rolenames = rpUser.getRolename();
			//rpUser.setCid(Integer.valueOf(cnames.split("@",-1)[0]));
			//rpUser.setCname(cnames.split("@",-1)[1]);
			//rpUser.setDeptid(Integer.valueOf(deptnames.split("@",-1)[0]));
			//rpUser.setDeptname(deptnames.split("@",-1)[1]);
			//rpUser.setRoleid(Integer.valueOf(rolenames.split("@",-1)[0]));
			//rpUser.setRolename(rolenames.split("@",-1)[1]);
			rpUser.setPassword(EncryptUtil.encrypt(ConstantsUtil.INITPASSWOER,ConstantsUtil.ENCRYPTDATE));
			//rser.setPassword(password);
			rpUser.setIsdelete(ConstantsUtil.NOTDELETED);
			rpUser.setCreatedate(new Date());			
			result = rpUserDao.insertByRpUser(rpUser);		
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return result;
	}

	public boolean login(String username, String password) {
		boolean ret=false;
		RpUser user=rpUserDao.selectByUserName(username);

		if(null==username||null==password||username.equals("")||password.equals("")){
			return false;
		}

		if(null!=user&& ConstantsUtil.NOTDELETED.equals(user.getIsdelete())){//user存在且并未删除
			String pw=user.getPassword();
			if(pw.equals(EncryptUtil.encrypt(password, ConstantsUtil.ENCRYPTDATE))){
				ret=true;
			}
		}

		return ret;
	}

	public RpUser loginWithModelRet(String username,String password){
		RpUser user=rpUserDao.selectByUserName(username);

		if(null==username||null==password||username.equals("")||password.equals("")){
			return null;
		}

		if(null!=user&& ConstantsUtil.NOTDELETED.equals(user.getIsdelete())){//user存在且并未删除
			String pw=user.getPassword();
			if(pw.equals(EncryptUtil.encrypt(password, ConstantsUtil.ENCRYPTDATE))){
				return user;
			}
		}
		return null;
	}
	public int countByExample(RpUserExample example) {
		// TODO Auto-generated method stub
		return rpUserDao.countByExample(example);
	}
	public ArrayList<RpUser> selectByExample(RpUserExample example) {
		// TODO Auto-generated method stub
		return (ArrayList<RpUser>) rpUserDao.selectByExample(example);
	}
	public RpUser selectByPrimaryKey(Integer i) {
		// TODO Auto-generated method stub
		return rpUserDao.selectByPrimaryKey(i);
	}
	public int deleteByPrimaryKeyList(RpUserExample example) {
		// TODO Auto-generated method stub
		return rpUserDao.deleteByPrimaryKeyList(example);
	}
	public int updateByPrimaryKeySelective(RpUser rpUser) {
		// TODO Auto-generated method stub
		return rpUserDao.updateByPrimaryKeySelective(rpUser);
	}


}
