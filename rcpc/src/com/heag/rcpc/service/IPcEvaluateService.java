package com.heag.rcpc.service;

import java.util.ArrayList;

import com.heag.rcpc.model.PcEvaluate;
import com.heag.rcpc.model.PcEvaluateExample;

public interface IPcEvaluateService {
	
	String insertSelective(PcEvaluate pe);

	ArrayList<PcEvaluate> selectByExample(PcEvaluateExample pee);

	int deleteByExample(PcEvaluateExample pee);

	int updateByExampleSelective(PcEvaluate pe, PcEvaluateExample pee);

	int updateByPrimaryKeySelective(PcEvaluate pe);

	PcEvaluate selectByPrimaryKey(Integer integer);

}
