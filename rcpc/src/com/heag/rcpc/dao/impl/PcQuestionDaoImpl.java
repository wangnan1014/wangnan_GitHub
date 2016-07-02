package com.heag.rcpc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcQuestionDao;
import com.heag.rcpc.mapper.PcQuestionMapper;
import com.heag.rcpc.model.PcQuestion;
import com.heag.rcpc.model.PcQuestionExample;

/**
 * @author wn
 *
 */
public class PcQuestionDaoImpl implements IPcQuestionDao {
	@Autowired
	private PcQuestionMapper pcQuestionMapper;
	public Integer countByExample(PcQuestionExample pae) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteByPrimaryKey(Integer qid) {
		
		return pcQuestionMapper.deleteByPrimaryKey(qid)+"";
	}

	public String insertSelective(PcQuestion pa) {
		return pcQuestionMapper.insertSelective(pa)+"";
	}

	public ArrayList<PcQuestion> selectByExample(PcQuestionExample pae) {
		// TODO Auto-generated method stub
		return null;
	}

	public PcQuestion selectByPrimaryKey(Integer qid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateByPrimaryKey(PcQuestion pa) {
		return pcQuestionMapper.updateByPrimaryKey(pa)+"";
	}
	
	public String updateByPrimaryKeySelective(PcQuestion record){
		return pcQuestionMapper.updateByPrimaryKeySelective(record)+"";
	}
	
	public ArrayList<PcQuestion> selectQuestionAndOptions(PcQuestion pa) {
		return (ArrayList<PcQuestion>) pcQuestionMapper.selectQuestionAndOptions(pa);
	}

	public List<PcQuestion> selectQuestionContext(Integer aid) {
		// TODO Auto-generated method stub
		return  pcQuestionMapper.selectQuestionContext(aid);
	}

}
