package com.heag.rcpc.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.model.RpLog;
import com.heag.rcpc.model.RpLogExample;
import com.heag.rcpc.model.RpLogExample.Criteria;
import com.heag.rcpc.service.IRpLogService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport {
	@Autowired
	private IRpLogService rpLogService;
	HttpServletResponse res = ServletActionContext.getResponse();  
	HttpServletRequest req = ServletActionContext.getRequest();  
    public String execute() throws Exception {

           return SUCCESS;
    }	
	
	/*
	 * 获取log列表数据
	 * 
	 * */	
	public String getDataList() throws Exception {
				
		res.setCharacterEncoding("UTF-8");
		
		String example ="";
		
		String orderDir = req.getParameter("order[0][dir]");
		
		String orderColumn = req.getParameter("order[0][column]");
		
		String orderName = req.getParameter("columns["+orderColumn+"][data]");
		
		//String search = req.getParameter("search");// search[value], search[regex]
		
		String start = req.getParameter("start");
		
		String end = req.getParameter("length");
		
		String st = req.getParameter("startDate");

		String et = req.getParameter("endDate");

		String uname = req.getParameter("uname");
		
		String tablename = req.getParameter("tablename");

		RpLogExample rle = new RpLogExample();
	
		Criteria criteria = rle.createCriteria();
		criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);

		if(!"".equals(uname)&&uname!=null){
			criteria.andUnameLike("%"+uname+"%");
		}
		if(!"".equals(tablename)&&tablename!=null){
			criteria.andTablenameLike("%"+tablename+"%");
		}
		//时间搜索
		if((!"".equals(st)&&st!=null)&&(!"".equals(et)&&et!=null)){
			
			SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantsUtil.DATEFOMART);
			criteria.andCreatedateBetween(dateFormat.parse(st),dateFormat.parse(et));
			
		} 
		
		if((!"".equals(orderName)&&orderName!=null)&&(!"".equals(orderDir)&&orderDir!=null)){
			
				example+=orderName+" "+orderDir +" ";
				
		}
		if((!"".equals(start)&&start!=null)&&(!"".equals(end)&&end!=null)){
				example+=" limit "+ start +"," + end;
		}				
		rle.setOrderByClause(example);
		
		ArrayList<RpLog> arr_rp = (ArrayList<RpLog>) rpLogService.selectList(rle);
		
		rle.setOrderByClause(null);
		
		int iTotalRecords = rpLogService.countByExample(null);
		
		int iTotalDisplayRecords = rpLogService.countByExample(rle);
		
		PrintWriter out = res.getWriter();
		
		Map map = new HashMap();
		
		map.put("data",arr_rp);
		
		map.put("iTotalRecords",iTotalRecords);
		
		map.put("iTotalDisplayRecords", iTotalDisplayRecords);
		
		map.put("sEcho",req.getParameter("sEcho"));
		
		out.print(JsonUtil.mapToJson(map));
		
		//out.print(JsonUtil.arrToJsonForDate(arr_rp));
		
		//out.flush();
		
    	out.close();
    	
    	return NONE;
    }
	//删除数据
	public String deleteLog() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();  
		HttpServletRequest req = ServletActionContext.getRequest(); 
		String keyVals =req.getParameter("data");
		//res.setContentType("text/xml;charset=UTF-8");  
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		int i= rpLogService.deleteByList(keyVals);
		out.print(i);
		//out.flush();
    	out.close();		
    	return NONE;
    }	
	/*
	 * 跳转页面
	 * 通过该方式让前台给div赋值
	 * */
	public String gotoPage() throws Exception {
		return SUCCESS;
    }
	
}
