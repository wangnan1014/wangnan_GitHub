package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpProvinceDao;
import com.heag.rcpc.mapper.RpProvinceMapper;
import com.heag.rcpc.model.RpProvince;
import com.heag.rcpc.model.RpProvinceExample;

public class RpProvinceDaoImpl implements IRpProvinceDao {
	@Autowired
	public RpProvinceMapper rpProvinceMapper;
	public ArrayList<RpProvince> selectByExample(RpProvinceExample rie) {
		// TODO Auto-generated method stub
		return (ArrayList<RpProvince>) rpProvinceMapper.selectByExample(rie);
	}
}
