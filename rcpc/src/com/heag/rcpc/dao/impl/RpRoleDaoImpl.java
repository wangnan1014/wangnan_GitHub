package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpRoleDao;
import com.heag.rcpc.mapper.RpRoleMapper;
import com.heag.rcpc.model.RpRole;
import com.heag.rcpc.model.RpRoleExample;


public class RpRoleDaoImpl implements IRpRoleDao{
	ArrayList<RpRole> al;
	@Autowired
	private RpRoleMapper rpRoleMapper;
	public int insert(RpRole rpRole) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<RpRole> select(RpRoleExample re) {
		// TODO Auto-generated method stub
		al = (ArrayList<RpRole>) rpRoleMapper.selectByExample(re);
		return al;
	}

	public int update(RpRole rpRole) {
		// TODO Auto-generated method stub
		return 0;
	}



}
