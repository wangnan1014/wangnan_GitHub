package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpProvinceDao;
import com.heag.rcpc.model.RpProvince;
import com.heag.rcpc.model.RpProvinceExample;
import com.heag.rcpc.service.IRpProvinceService;

public class RpProvinceServiceImpl implements IRpProvinceService {
	@Autowired
	private IRpProvinceDao rpProvinceDao;
	public ArrayList<RpProvince> selectByExample(RpProvinceExample rie) {
		// TODO Auto-generated method stub
		return rpProvinceDao.selectByExample(rie);
	}

}
