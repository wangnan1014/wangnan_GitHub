package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpCompanyDao;
import com.heag.rcpc.model.RpCompany;
import com.heag.rcpc.service.IRpCompanyService;
import com.heag.rcpc.model.RpCompanyExample;;

public class RpCompanyServiceImpl implements IRpCompanyService {
	@Autowired
	IRpCompanyDao  rpCompanyDao;	
	public ArrayList<RpCompany> select() {
		// TODO Auto-generated method stub
		//RpCompanyExample re = new RpCompanyExample();
		//re.setOrderByClause("cid");
		return rpCompanyDao.select(null);
	}
	public ArrayList<RpCompany> selectByExample(RpCompanyExample rce) {
		// TODO Auto-generated method stub
		return rpCompanyDao.selectByExample(null);
	}

}
