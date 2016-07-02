package com.heag.rcpc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcEvaluateRelationDao;
import com.heag.rcpc.dao.IPcOptionsDao;
import com.heag.rcpc.dao.IPcResultDao;
import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcEvaluateRelation;
import com.heag.rcpc.model.PcResult;
import com.heag.rcpc.model.PcResultExample;
import com.heag.rcpc.model.PcResultExample.Criteria;
import com.heag.rcpc.service.IPcResultService;
import com.heag.rcpc.util.ConstantsUtil;

public class PcResultServiceImpl implements IPcResultService {
	@Autowired
	private IPcResultDao  pcResultDao;
	@Autowired
	private IPcEvaluateRelationDao  pcEvaluateRelationDao;	
	@Autowired
	private IPcOptionsDao  pcOptionsDao;
 
	
	public String insertSelective(Integer aid, Integer eid, Integer id,String evaluator,String[] qidVals, Map map) {
		int qidLen = qidVals.length;
		String result ="0";
			for(int i=0;i<qidLen;i++){
				PcResult pr = new PcResult();
				pr.setAid(aid);
				pr.setEid(eid);
				pr.setId(id);
				pr.setAid(aid);
				pr.setQid(new Integer(qidVals[i]));
				String oid =((String[]) map.get("qid_"+qidVals[i]))[0];
				pr.setRresult(oid);
				pr.setRemark(pcOptionsDao.selectByPrimaryKey(new Integer(oid)).getOoption());
				//pr.setRemark(((String[]) map.get("ooption_"+qidVals[i]))[0]);//选项中文
				if(i==0){
					PcEvaluateRelation re= pcEvaluateRelationDao.selectByPrimaryKey(id);
					evaluator = re.getEvaluator();
				}
				pr.setEvaluator(evaluator);//评估人姓名
				pr.setIsdelete(ConstantsUtil.NOTDELETED);
				pr.setCreatedate(new Date());
				result = pcResultDao.insertSelective(pr);
			}

		return result;
	}
	public int countByExample(Integer aid, Integer eid, Integer id,
			String evaluator) {
		PcResultExample pre= new PcResultExample();
		Criteria criteria = pre.createCriteria();
		criteria.andAidEqualTo(aid);
		criteria.andAidEqualTo(eid);
		criteria.andAidEqualTo(id);
		return pcResultDao.countByExample(pre);
	}
	
	public ArrayList<PcAskinfo> getPersonAnswer(PcResult pr) {
		// TODO Auto-generated method stub
		return pcResultDao.getPersonAnswer(pr);
	}

}
