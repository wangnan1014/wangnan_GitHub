package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcAskinfoDao;
import com.heag.rcpc.mapper.PcAskinfoMapper;
import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcAskinfoExample;

public class PcAskinfoDaoImpl implements IPcAskinfoDao {
	@Autowired
	private PcAskinfoMapper pcAskinfoMapper;
	public Integer countByExample(PcAskinfoExample pae) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteByPrimaryKey(Integer aid) {
		return pcAskinfoMapper.deleteByPrimaryKey(aid)+"";
	}

	public String insertSelective(PcAskinfo pa) {
		return pcAskinfoMapper.insertSelective(pa)+"";
	}

	public ArrayList<PcAskinfo> selectByExample(PcAskinfoExample pae) {
 		return (ArrayList<PcAskinfo>) pcAskinfoMapper.selectByExample(pae);
	}

	public PcAskinfo selectByPrimaryKey(Integer aid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateByPrimaryKeySelective(PcAskinfo pa) {
		return pcAskinfoMapper.updateByPrimaryKeySelective(pa)+"";
	}

	public ArrayList<PcAskinfo> getAskinfoAndQuestionAndOption(PcAskinfo pa) {
		// TODO Auto-generated method stub
		return (ArrayList<PcAskinfo>) pcAskinfoMapper.getAskinfoAndQuestionAndOption(pa);
	}

}
