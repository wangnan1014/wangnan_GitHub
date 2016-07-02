package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpCompanyDao;
import com.heag.rcpc.dao.IRpDepartmentDao;
import com.heag.rcpc.model.RpCompanyExample;
import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpDepartmentExample;
import com.heag.rcpc.service.IRpDepartmentService;

public class RpDepartmentServiceImpl implements IRpDepartmentService {
	@Autowired
	IRpDepartmentDao  rpDepartmentDao;
	public ArrayList<RpDepartment> select() {
		// TODO Auto-generated method stub
		//RpDepartmentExample re = new RpDepartmentExample();
		//re.setOrderByClause("did");
		return rpDepartmentDao.select(null);
	}

	public ArrayList<RpDepartment> selectByExample(RpDepartmentExample rde) {
		return rpDepartmentDao.selectByExample(null);
	}

}
