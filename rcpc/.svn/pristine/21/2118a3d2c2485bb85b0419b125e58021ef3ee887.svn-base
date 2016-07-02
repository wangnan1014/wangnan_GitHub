package com.heag.rcpc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.RpUserExample;
import com.heag.rcpc.model.RpUserExample.Criteria;
import com.heag.rcpc.service.IRpLogService;
import com.heag.rcpc.service.IRpUserService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final Logger logger=Logger.getLogger("report.debug");
	private String actionName;
	private String uid;
	private RpUser rpuser;

	@Autowired
	private IRpUserService rpUserService;

	@Autowired
    private IRpLogService rpLogService;	
    private HttpServletRequest req = ServletActionContext.getRequest();       
    private HttpSession session = ServletActionContext.getRequest().getSession();      
    private HttpServletResponse res = ServletActionContext.getResponse() ;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public String getDataList() throws IOException {
		res.setCharacterEncoding("UTF-8");
		String example ="";
		String orderDir = req.getParameter("order[0][dir]");
		String orderColumn = req.getParameter("order[0][column]");
		String orderName = req.getParameter("columns["+orderColumn+"][data]");
		String start = req.getParameter("start");
		String end = req.getParameter("length");
		String uname = req.getParameter("uname");
		String realname = req.getParameter("realname");
		String cname = req.getParameter("cname");
		String deptname = req.getParameter("deptname");
		String rolename = req.getParameter("rolename");		
		RpUserExample rpe = new RpUserExample();
		Criteria criteria = rpe.createCriteria();
		criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);

		if(!"".equals(uname)&&uname!=null){
			criteria.andUnameLike("%"+uname+"%");
		}
		if(!"".equals(realname)&&realname!=null){
			criteria.andRealnameLike("%"+realname+"%");
		}
		if(!"".equals(cname)&&cname!=null){
			criteria.andCnameLike("%"+cname+"%");
		}
		if(!"".equals(deptname)&&deptname!=null){
			criteria.andDeptnameLike("%"+deptname+"%");
		}	
		if(!"".equals(rolename)&&rolename!=null){
			criteria.andRolenameLike("%"+rolename+"%");
		}			
		if((!"".equals(orderName)&&orderName!=null)&&(!"".equals(orderDir)&&orderDir!=null)){
			example+=orderName+" "+orderDir +" ";
		}
		if((!"".equals(start)&&start!=null)&&(!"".equals(end)&&end!=null)){
			example+=" limit "+ start +"," + end;
		}
		rpe.setOrderByClause(example);
		
		ArrayList<RpUser> arr_rp = rpUserService.selectByExample(rpe);
		
		rpe.setOrderByClause(null);
		
		int iTotalRecords = rpUserService.countByExample(null);
		
		int iTotalDisplayRecords = rpUserService.countByExample(rpe);
		
		PrintWriter out = res.getWriter();

		Map map = new HashMap();
		
		map.put("data",arr_rp);
		
		map.put("iTotalRecords",iTotalRecords);
		
		map.put("iTotalDisplayRecords", iTotalDisplayRecords);
		
		map.put("sEcho",req.getParameter("sEcho"));	
		/**
		if(!arr_rp.equals(null)){
			logger.info("======get one project");
			RpUser user = (RpUser) session.getAttribute("user");
			rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LSELECT, req.getRequestURI(), "rp_User","ALL", null, null, null);
		} 
		*/

		out.print(JsonUtil.mapToJson(map));
    	out.close();	
    	logger.info("=======get user list");    	
    	return NONE;
    }
	/*
	 * 获取一条数据
	 * 
	 * */
	public String getDataOne() throws Exception {	
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		RpUser rp = rpUserService.selectByPrimaryKey(Integer.valueOf(uid));
		//if(rp!=null){
		//	logger.info("======get one project");
		//	RpUser user = (RpUser) session.getAttribute("user");
		//	rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LSELECT, req.getRequestURI(), "rp_project", pid, null, null, null);
		//}
		Map map = new HashMap();
		map.put("data", rp);
		out.print(JsonUtil.mapToJson(map));
		//out.flush();
    	out.close();
    	return NONE;
    }
	/*
	 * 获取一条数据
	 * 
	 * */	
	public String deleteUser() throws IOException {
		String keyVals =req.getParameter("data");
		String t = req.getParameter("t");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		//int i= rpProjectService.deleteByList(keyVals);
		RpUserExample rpe = new RpUserExample();
		Criteria criteria = rpe.createCriteria();
		criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);
		String[] sVal= keyVals.split(",", -1);
		int x = sVal.length;
		Integer[] ival = new Integer[x];
		for (int j = 0; j < x; j++) {
			ival[j] = Integer.valueOf(sVal[j]);
		}
		if("0".equals(t)){//全选状态
			criteria.andUidNotIn(Arrays.asList(ival));
		}else if("1".equals(t)){
			criteria.andUidIn(Arrays.asList(ival));	
		}

		int i = 0;
		if(!"".equals(keyVals)||"0".equals(t)){
			i = rpUserService.deleteByPrimaryKeyList(rpe);
			if(i>0){
		    	logger.info("======delete one project ");
				RpUser user = (RpUser) session.getAttribute("user");
				rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LDELETE, req.getRequestURI(), "rp_user", keyVals, null, null, null);
			}   		
		}

		out.print(i);
		//out.flush();
    	out.close();

    	return NONE;
	}
	/**
	 * 编辑一条数据
	 * 
	 * */
	public String saveUser() throws Exception {
		String keyVals =req.getParameter("data");
		String changedName = req.getParameter("changedProperty");
		String changedDate = req.getParameter("changedPropertyDate");
		String oldDate =  req.getParameter("oldDate");
		
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		int i =  rpUserService.updateByPrimaryKeySelective(rpuser);
		if(i>0){
			logger.info("======edit one User ");
			RpUser user = (RpUser) session.getAttribute("user");
			//rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LMODIFY, req.getRequestURI(), "rp_project", rpProject.getPid().toString(), null, null, null);
			String[] cn = changedName.split(",");
			String[] cd = changedDate.split(",");
			String[] od = oldDate.split(",");
			int len = cn.length;
			for(int x=0;x<len;x++){
				rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LMODIFY, req.getRequestURI(), "rp_user", rpuser.getUid().toString(), cn[x], od[x], cd[x]);
			}
		}    
		out.print(i);
		//out.flush();
    	out.close();
    	return NONE;
    }		
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public RpUser getRpuser() {
		return rpuser;
	}
	public void setRpuser(RpUser rpuser) {
		this.rpuser = rpuser;
	}

}



