package com.heag.rcpc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpProjectDao;
import com.heag.rcpc.mapper.RpProjectMapper;
import com.heag.rcpc.model.RpProject;
import com.heag.rcpc.model.RpProjectExample;
/*
 * Created by 2016.6.30
 * 
 * */
public class RpProjectDaoImpl implements IRpProjectDao {
	@Autowired
	public RpProjectMapper rpProjectMapper;
	public ArrayList<RpProject> selectByExample(RpProjectExample rpe) {
		// TODO Auto-generated method stub
		return (ArrayList<RpProject>) rpProjectMapper.selectByExample(rpe);
	}
	public RpProject selectByPrimaryKey(int pid) {
		// TODO Auto-generated method stub
		return rpProjectMapper.selectByPrimaryKey(pid);
	}		
	public int deleteByList(RpProjectExample rpe) {
		// TODO Auto-generated method stub
		return rpProjectMapper.deleteByPrimaryKeyList(rpe);
	}
	public int insertSelective(RpProject rpProject) {
		// TODO Auto-generated method stub
		return rpProjectMapper.insertSelective(rpProject);
	}
	public int updateByPrimaryKeySelective(RpProject rpProject) {
		// TODO Auto-generated method stub
		return rpProjectMapper.updateByPrimaryKeySelective(rpProject);
	}
	public List<Map> selectProjectMapReport(Map map) {
		// TODO Auto-generated method stub
		return rpProjectMapper.selectProjectMapReport(map);
	}
	public int countByExample(RpProjectExample rpe) {
		// TODO Auto-generated method stub
		return rpProjectMapper.countByExample(rpe);
	}
}
