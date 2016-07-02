package com.heag.rcpc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.heag.rcpc.dao.IRpProjectDao;
import com.heag.rcpc.model.RpProject;
import com.heag.rcpc.model.RpProjectExample;
import com.heag.rcpc.service.IRpProjectService;
import com.heag.rcpc.util.ConstantsUtil;


/*
 * Created by 2016.6.30
 * 
 * */
public class RpProjectServiceImpl implements IRpProjectService {
	public IRpProjectDao rpProjectDao;

	public ArrayList<RpProject> selectByExample(RpProjectExample rpe) {
		return rpProjectDao.selectByExample(rpe);
	}
	public RpProject selectByPrimaryKey(int pid) {
		// TODO Auto-generated method stub
		return rpProjectDao.selectByPrimaryKey(pid);
	}	
	public int deleteByList(RpProjectExample rpe) {
		return rpProjectDao.deleteByList(rpe);
	}	
	public int insertSelective(RpProject rpProject) {
		Date d = new Date();
		rpProject.setUpdatedate(d);
		rpProject.setCreatedate(d);
		rpProject.setIsdelete(ConstantsUtil.NOTDELETED);
		return rpProjectDao.insertSelective(rpProject);
	}
	public int updateByPrimaryKeySelective(RpProject rpProject) {
		rpProject.setUpdatedate(new Date());
		return rpProjectDao.updateByPrimaryKeySelective(rpProject);
	}	
	public ArrayList<Map> selectProjectMapReport(Map para) {
		return (ArrayList<Map>) rpProjectDao.selectProjectMapReport(para);
	}
	public IRpProjectDao getRpProjectDao() {
		return rpProjectDao;
	}
	public void setRpProjectDao(IRpProjectDao rpProjectDao) {
		this.rpProjectDao = rpProjectDao;
	}
	public int countByExample(RpProjectExample rpe) {
		
		return rpProjectDao.countByExample(rpe);
	}

}
