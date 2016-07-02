package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcAskinfoDao;
import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcAskinfoExample;
import com.heag.rcpc.model.PcAskinfoExample.Criteria;
import com.heag.rcpc.service.IPcAskinfoService;
import com.heag.rcpc.util.ConstantsUtil;

public class PcAskinfoServiceImpl implements IPcAskinfoService {
	@Autowired
	private IPcAskinfoDao pcAskinfoDao;
	
	public String insertSelective(PcAskinfo pa) {
		
		return pcAskinfoDao.insertSelective(pa);
	}

	public ArrayList<PcAskinfo> selectByExample(PcAskinfoExample pa) {
		pa.setOrderByClause("aid DESC");
		return pcAskinfoDao.selectByExample(pa);
	}

	public String deleteByPrimaryKey(String aid) {
		return pcAskinfoDao.deleteByPrimaryKey(new Integer(aid));
	}
				  
	public String updateByPrimaryKeySelective(PcAskinfo pa) {
		return pcAskinfoDao.updateByPrimaryKeySelective(pa);
	}

	public ArrayList<PcAskinfo> getAskinfoAndQuestionAndOption(PcAskinfo record) {
		return pcAskinfoDao.getAskinfoAndQuestionAndOption(record);
	}
}
