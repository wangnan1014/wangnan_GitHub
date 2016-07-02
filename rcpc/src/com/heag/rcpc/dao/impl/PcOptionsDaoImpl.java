package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcOptionsDao;
import com.heag.rcpc.mapper.PcOptionsMapper;
import com.heag.rcpc.model.PcOptions;
import com.heag.rcpc.model.PcOptionsExample;

public class PcOptionsDaoImpl implements IPcOptionsDao {
	@Autowired
	private PcOptionsMapper pcOptionsMapper;
	    
	public Integer countByExample(PcOptionsExample poe) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteByPrimaryKey(Integer oid) {
		
		return pcOptionsMapper.deleteByPrimaryKey(oid)+"";
	}

	public String insertSelective(PcOptions po) {
		return pcOptionsMapper.insertSelective(po)+"";
	}

	public ArrayList<PcOptions> selectByExample(PcOptionsExample poe) {
		// TODO Auto-generated method stub
		return null;
	}

	public PcOptions selectByPrimaryKey(Integer oid) {
		// TODO Auto-generated method stub
		return pcOptionsMapper.selectByPrimaryKey(oid);
	}

	public String updateByPrimaryKey(PcOptions po) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateByExampleSelective(PcOptions record,PcOptionsExample example) {

		return pcOptionsMapper.updateByExampleSelective(record,example)+"";
	}

}
