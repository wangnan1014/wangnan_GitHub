package com.heag.rcpc.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcEvaluateRelationDao;
import com.heag.rcpc.model.PcEvaluateRelation;
import com.heag.rcpc.model.PcEvaluateRelationExample;
import com.heag.rcpc.model.PcSendInvitations;
import com.heag.rcpc.service.IPcSendInvitationsService;

public class PcSendInvitationsServiceImpl implements IPcSendInvitationsService {

	public String deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertSelective1(PcEvaluateRelation pa) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertSelective1(PcSendInvitations pa) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateByPrimaryKeySelective(PcEvaluateRelation pa) {
		// TODO Auto-generated method stub
		return null;
	}
	//public ArrayList<PcEvaluateRelation> selectByExample(PcEvaluateRelationExample pae);
	
	public ArrayList<PcEvaluateRelation> selectByExample(
			PcEvaluateRelationExample per) {
		// TODO Auto-generated method stub
		return pcEvaluateRelationDao.selectByExample(per);
	}
	public ArrayList<PcEvaluateRelation> selectEname(
			PcEvaluateRelationExample pre) {
		// TODO Auto-generated method stub
		return pcEvaluateRelationDao.selectEname(pre);
	}

	
	@Autowired
	private IPcEvaluateRelationDao pcEvaluateRelationDao;


	

	
}