package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IRpCompanyDao;
import com.heag.rcpc.mapper.RpCompanyMapper;
import com.heag.rcpc.model.RpCompany;
import com.heag.rcpc.model.RpCompanyExample;
import com.heag.rcpc.model.RpCompany;

public class RpCompanyDaoImpl implements IRpCompanyDao {
	ArrayList<RpCompany> al;
	@Autowired
	private RpCompanyMapper rpCompanyMapper;
	public ArrayList<RpCompany> select(RpCompanyExample re) {
		al = (ArrayList<RpCompany>) rpCompanyMapper.selectByExample(re);
		return al;
	}
	public ArrayList<RpCompany> selectByExample(RpCompanyExample re) {
		al = (ArrayList<RpCompany>) rpCompanyMapper.selectByExample(re);
		return al;
	}
}
