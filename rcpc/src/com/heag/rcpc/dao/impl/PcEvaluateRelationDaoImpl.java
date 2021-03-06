package com.heag.rcpc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcEvaluateRelationDao;
import com.heag.rcpc.mapper.PcEvaluateRelationMapper;
import com.heag.rcpc.model.PcEvaluateRelation;
import com.heag.rcpc.model.PcEvaluateRelationExample;

public class PcEvaluateRelationDaoImpl implements IPcEvaluateRelationDao {
	
	public ArrayList<PcEvaluateRelation> selectByExample(PcEvaluateRelationExample pae) {
		// TODO Auto-generated method stub
		return (ArrayList<PcEvaluateRelation>) pcEvaluateRelationMapper.selectByExample(pae);
	}
	
	public String insertSelective(PcEvaluateRelation per) {
		// TODO Auto-generated method stub
		int result=pcEvaluateRelationMapper.insertSelective(per);
		return result+"";
	}
	
	
	public int updateByExampleSelective(PcEvaluateRelation per,PcEvaluateRelationExample pere) {
		// TODO Auto-generated method stub
		return pcEvaluateRelationMapper.updateByExampleSelective(per, pere);
	}

	public int updateByPrimaryKeySelective(PcEvaluateRelation per) {
		// TODO Auto-generated method stub
		return pcEvaluateRelationMapper.updateByPrimaryKeySelective(per);
	}
	
	public ArrayList<PcEvaluateRelation> selectEname(
			PcEvaluateRelationExample pre) {
		// TODO Auto-generated method stub
		return pcEvaluateRelationMapper.selectEname(pre);
	}

	public String updateByPrimaryKey(PcEvaluateRelation pa) {
		// TODO Auto-generated method stub
		return null;
	}

	


	public Integer countByExample(PcEvaluateRelationExample pae) {
		// TODO Auto-generated method stub
		return pcEvaluateRelationMapper.countByExample(pae);
	}

	public String deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public PcEvaluateRelation selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return pcEvaluateRelationMapper.selectByPrimaryKey(id);
	}

	


	@Autowired
	private PcEvaluateRelationMapper pcEvaluateRelationMapper;


	public List<Map<String, String>> selectEvaluateAndEvaluateRelationByAid(
			Integer aid) {
		return pcEvaluateRelationMapper.selectEvaluateAndEvaluateRelationByAid(aid);
	}



	

}
