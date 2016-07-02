package com.heag.rcpc.dao.impl;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.heag.rcpc.dao.IRpUserDao;
import com.heag.rcpc.mapper.RpUserMapper;
import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.RpUserExample;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.EncryptUtil;

import java.util.List;

/**
 * Created by Administrator on 2015-6-23 0023.
 * 实现类
 */
public class RpUserDaoImpl implements IRpUserDao {
	@Autowired
	private RpUserMapper rpUserMapper;     
    public int insert(String uname, String password) throws DataAccessException{
		// TODO Auto-generated method stub 	
		RpUser rser = new RpUser();
		rser.setUname(uname);
		EncryptUtil eu = new EncryptUtil();
		rser.setPassword(eu.encrypt(password ,"20101217190036"));
		//rser.setPassword(password);
		rser.setIsdelete(new Integer(0).byteValue());
		rser.setCreatedate(new Date());
		int  result = rpUserMapper.insertSelective(rser);
		return result;
	}
	public int update(int uid, String password) {
		// TODO Auto-generated method stub
		RpUser rser = new RpUser();
		rser.setUid(uid);
		EncryptUtil eu = new EncryptUtil();
		rser.setPassword(eu.encrypt(password ,ConstantsUtil.ENCRYPTDATE));
		rpUserMapper.updateByPrimaryKeySelective(rser);
		return 0;
	}
	
	public RpUser select(String uname) throws DataAccessException{
		// TODO Auto-generated method stub
		RpUser rser = new RpUser();
		rser = rpUserMapper.selectByUname(uname);
		//RpUserMapper.countByExample();
		return rser;
	}
	public int insertByRpUser(RpUser rpUser) {
		// TODO Auto-generated method stub
		int  result = rpUserMapper.insertSelective(rpUser);
		return result;
	}

    public RpUser selectByUserName(String username) {
        return rpUserMapper.selectByUname(username);
    }

    public int insert(RpUser rpUser) {
        if(1==rpUserMapper.insert(rpUser)){
            return rpUserMapper.selectLastInsertId();
        }else{
            return 0;
        }
    }

    public List<RpUser> selectByExample(RpUserExample example) {
        return rpUserMapper.selectByExample(example);
    }
	public int countByExample(RpUserExample example) {
		// TODO Auto-generated method stub
		return rpUserMapper.countByExample(example);
	}
	public RpUser selectByPrimaryKey(Integer i) {
		// TODO Auto-generated method stub
		return rpUserMapper.selectByPrimaryKey(i);
	}
	public int deleteByPrimaryKeyList(RpUserExample example) {
		// TODO Auto-generated method stub
		return rpUserMapper.deleteByPrimaryKeyList(example);
	}
	public int updateByPrimaryKeySelective(RpUser rpUser) {
		// TODO Auto-generated method stub
		return rpUserMapper.updateByPrimaryKeySelective(rpUser);
	}

}
