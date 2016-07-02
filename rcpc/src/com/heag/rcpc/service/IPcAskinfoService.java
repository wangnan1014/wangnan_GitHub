package com.heag.rcpc.service;

import java.util.ArrayList;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcAskinfoExample;

public interface IPcAskinfoService {

	String insertSelective(PcAskinfo pa);

	ArrayList<PcAskinfo> selectByExample(PcAskinfoExample pae);

	String deleteByPrimaryKey(String aid);

	String updateByPrimaryKeySelective(PcAskinfo pa);
	ArrayList<PcAskinfo> getAskinfoAndQuestionAndOption(PcAskinfo record);	
}
