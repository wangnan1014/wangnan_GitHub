package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpIndustryDao;
import com.heag.rcpc.model.RpIndustry;
import com.heag.rcpc.model.RpIndustryExample;
import com.heag.rcpc.service.IRpIndustryService;

public class RpIndustryServiceImpl implements IRpIndustryService {
	@Autowired
	private IRpIndustryDao rpIndustryDao;
	public ArrayList<RpIndustry> selectByExample(RpIndustryExample rie) {
		// TODO Auto-generated method stub
		return rpIndustryDao.selectByExample(rie);
	}

}
