package com.heag.rcpc.service.impl;

import java.util.Date;

import com.heag.rcpc.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.heag.rcpc.action.RegisterAction;
import com.heag.rcpc.dao.IRpLogDao;
import com.heag.rcpc.dao.RegisterDao;
import com.heag.rcpc.dao.impl.RegisterDaoImpl;
import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.service.RegisterService;
import com.heag.rcpc.util.ApplicationUtil;
import com.heag.rcpc.util.EncryptUtil;

public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDao registerDao;
	public int insert(String uname, String password) {
		// TODO Auto-generated method stub
		//RegisterDao rd = (RegisterDao) ApplicationUtil.getBean("registerDao");
		
		int result = 0;
		try {
			result = registerDao.insert(uname, password);		
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return result;
	}
	public int update(int uid, String password) {
		// TODO Auto-generated method stub
		//RegisterDao rd = new RegisterDaoImpl();
		//RegisterDao rd = (RegisterDao) ApplicationUtil.getBean("registerDao");
		int result = registerDao.update(uid, password);
		return result;
	} 
	
	public RpUser select(String uname) {
		// TODO Auto-generated method stub
		//RegisterDao rd = new RegisterDaoImpl();
		//RegisterDao rd = (RegisterDao) ApplicationUtil.getBean("registerDao");
		RpUser rpUser = null;
		try {
		rpUser = registerDao.select(uname);
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
			rpUser.setPassword(EncryptUtil.encrypt(rpUser.getPassword(), ConstantsUtil.ENCRYPTDATE));
			//rser.setPassword(password);
			rpUser.setIsdelete(new Integer(0).byteValue());
			rpUser.setCreatedate(new Date());			
			result = registerDao.insertByRpUser(rpUser);		
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return result;
	}	
	
}
