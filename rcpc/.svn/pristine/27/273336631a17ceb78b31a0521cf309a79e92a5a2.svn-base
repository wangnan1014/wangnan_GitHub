package com.heag.rcpc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heag.rcpc.dao.IRpLogDao;
import com.heag.rcpc.dao.impl.RpLogDaoImpl;
import com.heag.rcpc.model.RpLog;
import com.heag.rcpc.model.RpLogExample;
import com.heag.rcpc.service.IRpLogService;
import com.heag.rcpc.util.ConstantsUtil;

/**
 * Created by Administrator on 2015-6-23 0023.
 */
public class RpLogServiceImpl implements IRpLogService {

    private IRpLogDao rpLogDao;

    /**
     * 新增一条日志信息
     * @param uid 用户id 必填
     * @param username 用户名 必填
     * @param companyid 公司id
     * @param companyname 公司名
     * @param deptid 部门id
     * @param deptname 部门名
     * @param action 操作行为
    1 登录
    2 登出
    3 查询
    4 新增
    5 修改
    6 删除
    7 导出数据
     * @param page 涉及页面
     * @param tablename 涉及的数据库表
     * @param dataid 涉及的数据库表记录主键
     * @param dataname 涉及的字段名
     * @param beforeupdate 更新前数据
     * @param afterupdate 更新后数据
     * @return
     */
    public Boolean insert(Integer uid, String username, Integer companyid, String companyname, Integer deptid, String deptname, Integer action, String page, String tablename, String dataid, String dataname, String beforeupdate, String afterupdate) {
        //TODO 必填项目判空 uid,username,action,page
        if(null==uid||uid.equals("")){
            return false;
        }else if(null==username||username.equals("")){
            return false;
        }else if(null==action||action.equals("")){
            return false;
        }else if(null==page||page.equals("")){
            return false;
        }

        RpLog log=new RpLog();
        log.setUid(uid);
        log.setUname(username);
        log.setCid(companyid);
        log.setCname(companyname);
        log.setDeptid(deptid);
        log.setDeptname(deptname);
        log.setAction(action.byteValue());
        log.setPage(page);
        log.setTablename(tablename);
        log.setDataid(dataid);
        log.setDataname(dataname);
        log.setBeforeupdate(beforeupdate);
        log.setAfterupdate(afterupdate);
        log.setCreatedate(new Date());
        log.setIsdelete(ConstantsUtil.NOTDELETED);
        if(0==rpLogDao.insert(log)){
            return false;
        }else{
            return true;
        }

    }
	public int deleteByList(String keyVals) {
		// TODO Auto-generated method stub
		return rpLogDao.deleteByList(keyVals);
	}
    public void setRpLogDao(IRpLogDao rpLogDao) {
        this.rpLogDao = rpLogDao;
    }

	public List<RpLog> selectList(RpLogExample rle) {
		// TODO Auto-generated method stub
		return rpLogDao.selectByExample(rle);
	}
	public int countByExample(RpLogExample rle) {
		// TODO Auto-generated method stub
		
		return rpLogDao.countByExample(rle);
	}


}
