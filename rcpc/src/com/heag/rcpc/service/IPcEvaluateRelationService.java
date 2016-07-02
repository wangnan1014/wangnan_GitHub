package com.heag.rcpc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.heag.rcpc.model.PcEvaluateRelation;
import com.heag.rcpc.model.PcEvaluateRelationExample;

public interface IPcEvaluateRelationService {

	ArrayList<PcEvaluateRelation> selectByExample(PcEvaluateRelationExample pee);

	String insertSelective(PcEvaluateRelation per);

	int updateByExampleSelective(PcEvaluateRelation per,PcEvaluateRelationExample pere);

	int updateByPrimaryKeySelective(PcEvaluateRelation per);
	
	int countByExample(Integer aid,Integer eid,Integer id, String evaluator);
	List<Map<String, String>> selectEvaluateAndEvaluateRelationByAid(Integer aid);
}
