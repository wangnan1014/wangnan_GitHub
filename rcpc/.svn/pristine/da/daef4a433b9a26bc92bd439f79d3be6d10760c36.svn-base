package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpDepartmentDao;
import com.heag.rcpc.mapper.RpDepartmentMapper;
import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpDepartmentExample;

public class RpDepartmentDaoImpl implements IRpDepartmentDao  {
	ArrayList<RpDepartment> al;
	@Autowired
	private RpDepartmentMapper rpDepartmentMapper;
	public ArrayList<RpDepartment> select(RpDepartmentExample re) {
		// TODO Auto-generated method stub
		al = (ArrayList<RpDepartment>) rpDepartmentMapper.selectByExample(re);
		return al;
	}
	public ArrayList<RpDepartment> selectByExample(RpDepartmentExample re) {
		// TODO Auto-generated method stub
		al = (ArrayList<RpDepartment>) rpDepartmentMapper.selectByExample(re);
		return al;
	}

}
