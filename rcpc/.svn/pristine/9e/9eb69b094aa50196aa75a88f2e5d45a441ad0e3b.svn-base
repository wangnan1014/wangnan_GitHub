package com.heag.rcpc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcOptionsDao;
import com.heag.rcpc.model.PcOptions;
import com.heag.rcpc.model.PcOptionsExample;
import com.heag.rcpc.service.IPcOptionsService;

public class PcOptionsServiceImpl implements IPcOptionsService {
	@Autowired
	private IPcOptionsDao pcOptionsDao;
	public String insertSelective(PcOptions po) {
		return pcOptionsDao.insertSelective(po);
	}
	public String deleteByPrimaryKey(Integer oid) {
		// TODO Auto-generated method stub
		return pcOptionsDao.deleteByPrimaryKey(oid);
	}
	public String updateByExampleSelective(PcOptions record,PcOptionsExample example) {
		// TODO Auto-generated method stub
		return pcOptionsDao.updateByExampleSelective(record,example);
	}


}
