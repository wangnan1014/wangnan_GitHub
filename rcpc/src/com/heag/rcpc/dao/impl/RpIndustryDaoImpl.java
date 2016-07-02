package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpIndustryDao;
import com.heag.rcpc.mapper.RpIndustryMapper;
import com.heag.rcpc.model.RpIndustry;
import com.heag.rcpc.model.RpIndustryExample;

public class RpIndustryDaoImpl implements IRpIndustryDao {
	@Autowired
	public RpIndustryMapper rpIndustryMapper;
	public ArrayList<RpIndustry> selectByExample(RpIndustryExample rie) {
		// TODO Auto-generated method stub
		return (ArrayList<RpIndustry>) rpIndustryMapper.selectByExample(rie);
	}

}
