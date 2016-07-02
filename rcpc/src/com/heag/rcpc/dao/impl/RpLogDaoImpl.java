package com.heag.rcpc.dao.impl;

import com.heag.rcpc.dao.IRpLogDao;
import com.heag.rcpc.mapper.RpLogMapper;
import com.heag.rcpc.model.RpLog;
import com.heag.rcpc.model.RpLogExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2015-6-23 0023.
 */
public class RpLogDaoImpl implements IRpLogDao {


    @Autowired
    private RpLogMapper rpLogMapper;

    public long insert(RpLog log) {
        if(1==rpLogMapper.insertSelective(log)){
            return rpLogMapper.selectLastInsertId();
        }else{
            return 0;
        }
    }

    public List<RpLog> selectByExample(RpLogExample example) {
        return rpLogMapper.selectByExample(example);
    }

	public int deleteByList(String keyVals) {
		// TODO Auto-generated method stub
		return rpLogMapper.deleteByPrimaryKeyList(keyVals);
	}

	public int countByExample(RpLogExample rle) {
		// TODO Auto-generated method stub
		return rpLogMapper.countByExample(rle);
	}
}
