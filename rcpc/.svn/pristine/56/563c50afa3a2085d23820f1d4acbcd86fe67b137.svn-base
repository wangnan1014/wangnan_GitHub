package com.heag.rcpc.service;

import java.util.ArrayList;
import java.util.Map;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcResult;


public interface IPcResultService {
	/**
	 * @param AID,qid,eid被评估人id，评估人id，评估人姓名evaluator，参数集map
	 * @author wn
	 *
	 */
	public String insertSelective(Integer aid,Integer eid,Integer id,String evaluator,String[] qidVals,Map map );
	/**
	 * @param AID,qid,eid被评估人id，评估人id，评估人姓名evaluator
	 * @author wn
	 * @return 返回符合条件记录数
	 */
	public int countByExample(Integer aid, Integer eid, Integer id, String evaluator);
	
	/**
	 * @param aid,eid,评估人id
	 * @author wcc
	 * @return 返回问卷答题详情
	 */
	public ArrayList<PcAskinfo> getPersonAnswer(PcResult pr);
}
