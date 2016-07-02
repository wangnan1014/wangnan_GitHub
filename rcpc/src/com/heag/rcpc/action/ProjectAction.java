package com.heag.rcpc.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.heag.rcpc.model.RpIndustry;
import com.heag.rcpc.model.RpProject;
import com.heag.rcpc.model.RpProjectExample;
import com.heag.rcpc.model.RpProvince;
import com.heag.rcpc.model.RpRegion;
import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.model.RpProjectExample.Criteria;
import com.heag.rcpc.service.IRpCompanyService;
import com.heag.rcpc.service.IRpDepartmentService;
import com.heag.rcpc.service.IRpIndustryService;
import com.heag.rcpc.service.IRpLogService;
import com.heag.rcpc.service.IRpProjectService;
import com.heag.rcpc.service.IRpProvinceService;
import com.heag.rcpc.service.IRpRegionService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;


public class ProjectAction extends ActionSupport {
	private static final Logger logger=Logger.getLogger("report.debug");
	private String gotoPage;
	private IRpProjectService rpProjectService;
	private RpProject rpProject;
	@Autowired
    private IRpLogService rpLogService;
	@Autowired
    private IRpCompanyService rpCompanyService;
	@Autowired
    private IRpDepartmentService rpDepartmentService;  
	@Autowired
	private IRpProvinceService rpProvinceService;
	@Autowired
	private IRpRegionService rpRegionService;
	@Autowired
	private IRpIndustryService rpIndustryService;
	private String actionName;
    private HttpServletRequest req = ServletActionContext.getRequest();       
    private HttpSession session = ServletActionContext.getRequest().getSession();      
    private HttpServletResponse res = ServletActionContext.getResponse() ;
    
	public String execute() throws Exception {
		return null;
    }
	
	/*
	 * 获取项目列表数据
	 * 
	 * */	
	public String getDataList() throws Exception {
	
		res.setCharacterEncoding("UTF-8");
		String example ="";
		String orderDir = req.getParameter("order[0][dir]");
		String orderColumn = req.getParameter("order[0][column]");
		String orderName = req.getParameter("columns["+orderColumn+"][data]").replaceAll("iContractid","i_Contractid").replaceAll("oContractid", "o_Contractid");
		String start = req.getParameter("start");
		String end = req.getParameter("length");
		String projectname = req.getParameter("projectname");
		String oContractid = req.getParameter("oContractid");
		String signdate_startDate = req.getParameter("signdate_startDate");
		String signdate_endDate = req.getParameter("signdate_endDate");
		
		RpProjectExample rpe = new RpProjectExample();
		Criteria criteria = rpe.createCriteria();
		criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);

		if(!"".equals(projectname)&&projectname!=null){
			criteria.andProjectnameLike("%"+projectname+"%");
		}
		if(!"".equals(oContractid)&&oContractid!=null){
			criteria.andOContractidLike("%"+oContractid+"%");
		}
		if((!"".equals(signdate_startDate)&&signdate_startDate!=null)&&(!"".equals(signdate_endDate)&&signdate_endDate!=null)){
			SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantsUtil.DATEFOMART);
			criteria.andSigndateBetween(dateFormat.parse(signdate_startDate),dateFormat.parse(signdate_endDate));			
		}
		
		if((!"".equals(orderName)&&orderName!=null)&&(!"".equals(orderDir)&&orderDir!=null)){
			example+=orderName+" "+orderDir +" ";
		}
		if((!"".equals(start)&&start!=null)&&(!"".equals(end)&&end!=null)){
			example+=" limit "+ start +"," + end;
		}
		rpe.setOrderByClause(example);
		
		ArrayList<RpProject> arr_rp = rpProjectService.selectByExample(rpe);
		
		rpe.setOrderByClause(null);
		
		int iTotalRecords = rpProjectService.countByExample(null);
		
		int iTotalDisplayRecords = rpProjectService.countByExample(rpe);
		
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
			rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LSELECT, req.getRequestURI(), "rp_project","ALL", null, null, null);
		} 
		*/
		//不知道为什么 这两个是大写  暂时先这样处理
		//out.print(JsonUtil.arrToJsonForProject(arr_rp));
		out.print(JsonUtil.mapToJson(map).replaceAll("IContractid","iContractid").replaceAll("OContractid", "oContractid"));
    	out.close();	
    	logger.info("=======》get project list");    	
    	return NONE;
    	}
	/*
	 * 获取一条项目数据
	 * 
	 * */
	public String getDataOne() throws Exception {	
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		String pid = req.getParameter("pid");
		RpProject rp = rpProjectService.selectByPrimaryKey(Integer.valueOf(pid));
		if(rp!=null){
			logger.info("======》get one project data");
			RpUser user = (RpUser) session.getAttribute("user");
			rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LSELECT, req.getRequestURI(), "rp_project", pid, null, null, null);
		}
		out.print(JsonUtil.objToJson(rp));
		//out.flush();
    	out.close();
    	return NONE;
    }
	/*
	 * 获取控件数据
	 * 
	 * */
	public String getInitColData() throws Exception {	
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		HashMap<String, ArrayList> m = new HashMap(); 
		ArrayList<RpIndustry> arr_ri = rpIndustryService.selectByExample(null);
		ArrayList<RpProvince> arr_rp = rpProvinceService.selectByExample(null);
		ArrayList<RpRegion> arr_rr = rpRegionService.selectByExample(null);
		m.put("itypename", arr_ri);
		m.put("province", arr_rp);
		m.put("region", arr_rr);
		out.print(JsonUtil.objToJson(m));
		//out.flush();
    	out.close();
    	return NONE;
    }
	/*
	 * 跳转页面
	 * 通过该方式让前台给div赋值
	 * */
	public String gotoPage() throws Exception {
		logger.info("go to " + gotoPage);
		//req = ServletActionContext.getRequest();			
		return SUCCESS;
    }
	/**
	 * add one Project
	 * 
	 * */
	public String addProject() throws Exception {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		int i= rpProjectService.insertSelective(rpProject);
		if(i>0){
			logger.info("======》add one project dada");
			RpUser user = (RpUser) session.getAttribute("user");
			rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LINSERT, req.getRequestURI(), "rp_project", rpProject.getPid().toString(), null, null, null);
		}
    	out.print(i);
		//out.flush();
    	out.close();
    return NONE;
    }
	/**
	 * saveProject
	 * 
	 * */
	public String saveProject() throws Exception {
		String keyVals =req.getParameter("data");
		String changedName = req.getParameter("changedProperty");
		String changedDate = req.getParameter("changedPropertyDate");
		String oldDate =  req.getParameter("oldDate");
		
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		int i =  rpProjectService.updateByPrimaryKeySelective(rpProject);
		if(i>0){
			logger.info("======》edit one project ");
			RpUser user = (RpUser) session.getAttribute("user");
			//rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LMODIFY, req.getRequestURI(), "rp_project", rpProject.getPid().toString(), null, null, null);
			String[] cn = changedName.split(",");
			String[] cd = changedDate.split(",");
			String[] od = oldDate.split(",");
			int len = cn.length;
			for(int x=0;x<len;x++){
				rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LMODIFY, req.getRequestURI(), "rp_project", rpProject.getPid().toString(), cn[x], od[x], cd[x]);
			}
		}    
		out.print(i);
		//out.flush();
    	out.close();
    	return NONE;
    }	
	//删除数据 
	public String deleteProject() throws Exception {
		String keyVals =req.getParameter("data");
		String t = req.getParameter("t");
		String signdate_startDate = req.getParameter("signdate_startDate");
		String signdate_endDate = req.getParameter("signdate_endDate");		
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		//int i= rpProjectService.deleteByList(keyVals);
		RpProjectExample rpe = new RpProjectExample();
		Criteria criteria = rpe.createCriteria();
		criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);
		String[] sVal= keyVals.split(",", -1);
		int x = sVal.length;
		Integer[] ival = new Integer[x];
		for (int j = 0; j < x; j++) {
			ival[j] = Integer.valueOf(sVal[j]);
		}
		if("0".equals(t)){//全选状态
			criteria.andPidNotIn(Arrays.asList(ival));
		}else if("1".equals(t)){
			criteria.andPidIn(Arrays.asList(ival));	
		}
		if((!"".equals(signdate_startDate)&&signdate_startDate!=null)&&(!"".equals(signdate_endDate)&&signdate_endDate!=null)){
			SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantsUtil.DATEFOMART);
			criteria.andSigndateBetween(dateFormat.parse(signdate_startDate),dateFormat.parse(signdate_endDate));			
		}
		int i = 0;
		if(!"".equals(keyVals)||"0".equals(t)){
			i = rpProjectService.deleteByList(rpe);
			if(i>0){
		    	logger.info("======》 delete  project ");
				RpUser user = (RpUser) session.getAttribute("user");
				rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LDELETE, req.getRequestURI(), "rp_project", keyVals, null, null, null);
			}   		
		}
		
		out.print(i);
		//out.flush();
    	out.close();

    	return NONE;
    }
	
	public String getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(String gotoPage) {
		this.gotoPage = gotoPage;
	}
	
	public IRpProjectService getRpProjectService() {
		return rpProjectService;
	}
	public void setRpProjectService(IRpProjectService rpProjectService) {
		this.rpProjectService = rpProjectService;
	}	
	public RpProject getRpProject() {
		return rpProject;
	}

	public void setRpProject(RpProject rpProject) {
		this.rpProject = rpProject;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void setRes(HttpServletResponse res) {
		this.res = res;
	}

}
