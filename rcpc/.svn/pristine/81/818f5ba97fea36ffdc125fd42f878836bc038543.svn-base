package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpRegionDao;
import com.heag.rcpc.mapper.RpRegionMapper;
import com.heag.rcpc.model.RpRegion;
import com.heag.rcpc.model.RpRegionExample;

public class RpRegionDaoImpl implements IRpRegionDao {
	@Autowired
	public RpRegionMapper rpRegionMapper;	
	public ArrayList<RpRegion> selectByExample(RpRegionExample rie) {
		// TODO Auto-generated method stub
		return (ArrayList<RpRegion>) rpRegionMapper.selectByExample(rie);
	}

}
