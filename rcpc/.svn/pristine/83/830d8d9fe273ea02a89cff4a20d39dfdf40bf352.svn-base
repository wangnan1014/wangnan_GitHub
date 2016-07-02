package com.heag.rcpc.service;

import java.util.ArrayList;
import java.util.List;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcQuestion;
import com.heag.rcpc.model.PcQuestionExample;

public interface IPcQuestionService {

	public ArrayList<PcQuestion> selectQuestionAndOptions(PcQuestion pq);
	public String insertSelective(PcQuestion pq);
	public String deleteByPrimaryKey(Integer qid);
	public String updateByPrimaryKey(PcQuestion pa);
	public String updateByPrimaryKeySelective(PcQuestion record);
	public List<PcQuestion> selectQuestionContext(Integer aid);
}
