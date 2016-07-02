package com.heag.rcpc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcQuestionDao;
import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcQuestion;
import com.heag.rcpc.model.PcQuestionExample;
import com.heag.rcpc.service.IPcQuestionService;

public class PcQuestionServiceImpl implements IPcQuestionService {
	@Autowired
	private IPcQuestionDao  pcQuestionDao;
	public ArrayList<PcQuestion> selectQuestionAndOptions(PcQuestion pq) {
		return pcQuestionDao.selectQuestionAndOptions(pq);
	}
	public String insertSelective(PcQuestion pq) {
		
		return pcQuestionDao.insertSelective(pq);
	}
	public String deleteByPrimaryKey(Integer qid) {
		
		return null;
	}
	public String updateByPrimaryKey(PcQuestion pa) {
		
		return pcQuestionDao.updateByPrimaryKey(pa);
	}
	public String updateByPrimaryKeySelective(PcQuestion record){
		return pcQuestionDao.updateByPrimaryKeySelective(record);
		
	}
	public List<PcQuestion> selectQuestionContext(Integer aid) {
		// TODO Auto-generated method stub
		return pcQuestionDao.selectQuestionContext(aid);
	}
}
