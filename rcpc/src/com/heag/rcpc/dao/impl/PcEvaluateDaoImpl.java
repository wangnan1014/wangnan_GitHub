package com.heag.rcpc.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.dao.IPcEvaluateDao;
import com.heag.rcpc.mapper.PcEvaluateMapper;
import com.heag.rcpc.model.PcEvaluate;
import com.heag.rcpc.model.PcEvaluateExample;

public class PcEvaluateDaoImpl implements IPcEvaluateDao {

	public Integer countByExample(PcEvaluateExample pae) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteByPrimaryKey(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertSelective(PcEvaluate pa) {
		int result =pcEvaluateMapper.insertSelective(pa);
		return result+"";
	}

	public ArrayList<PcEvaluate> selectByExample(PcEvaluateExample pee) {
		// TODO Auto-generated method stub
		return (ArrayList<PcEvaluate>) pcEvaluateMapper.selectByExample(pee);
	}
	
	public int deleteByExample(PcEvaluateExample pee) {
		// TODO Auto-generated method stub
		return pcEvaluateMapper.deleteByExample(pee);
	} 

	public int updateByExampleSelective(PcEvaluate pe, PcEvaluateExample pee) {
		// TODO Auto-generated method stub
		return pcEvaluateMapper.updateByExampleSelective(pe, pee);
	}
	
	public PcEvaluate selectByPrimaryKey(Integer eid) {
		// TODO Auto-generated method stub
		return pcEvaluateMapper.selectByPrimaryKey(eid);
	}

	public String updateByPrimaryKey(PcEvaluate pe) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int updateByPrimaryKeySelective(PcEvaluate pe) {
		// TODO Auto-generated method stub
		return pcEvaluateMapper.updateByPrimaryKeySelective(pe);
	}
	
	 


	
	
	@Autowired
	private PcEvaluateMapper pcEvaluateMapper;
 





	






	







	

	

}
