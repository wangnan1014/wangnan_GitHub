package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpRoleDao;
import com.heag.rcpc.model.RpRole;
import com.heag.rcpc.model.RpRoleExample;
import com.heag.rcpc.service.IRpRoleService;

public class RpRoleServiceImpl implements IRpRoleService {
	@Autowired
	IRpRoleDao  rpRoleDao;
	public int insert(RpRole rpRole) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<RpRole> select() {
		// TODO Auto-generated method stub
		//RpRoleExample re = new RpRoleExample();
		//re.setOrderByClause("roleid");

		return rpRoleDao.select(null);
	}

	public int update(RpRole rpRole) {
		// TODO Auto-generated method stub
		return 0;
	}

}
