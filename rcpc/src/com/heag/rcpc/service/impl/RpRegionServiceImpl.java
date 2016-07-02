package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpLogDao;
import com.heag.rcpc.dao.IRpRegionDao;
import com.heag.rcpc.model.RpRegion;
import com.heag.rcpc.model.RpRegionExample;
import com.heag.rcpc.service.IRpRegionService;

public class RpRegionServiceImpl implements IRpRegionService {
	@Autowired
	private IRpRegionDao regionDao;
	public ArrayList<RpRegion> selectByExample(RpRegionExample rie) {
		// TODO Auto-generated method stub
		return regionDao.selectByExample(rie);
	}

}
