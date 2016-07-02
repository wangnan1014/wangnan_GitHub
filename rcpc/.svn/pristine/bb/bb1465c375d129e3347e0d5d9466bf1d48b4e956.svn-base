package com.heag.rcpc.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcResult;
import com.heag.rcpc.service.IPcAskinfoService;
import com.heag.rcpc.service.IPcResultService;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;


public class ResultAction extends ActionSupport {
	private static final Logger logger=Logger.getLogger("report.debug");
	
	 
	HttpServletResponse response = ServletActionContext.getResponse();  
	HttpServletRequest request = ServletActionContext.getRequest(); 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	//得到个人答题情况
	public String getPersonAnswer(){
		 
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		ArrayList<PcAskinfo> arr=null;
		String result="0";
		String aid = request.getParameter("aid");
		String eid = request.getParameter("eid");
		String id = request.getParameter("id");
		try {
			
			pr= new PcResult();
			pr.setAid(Integer.parseInt(aid));
			pr.setEid(Integer.parseInt(eid));
			pr.setId(Integer.parseInt(id));
		
			arr= pcResultService.getPersonAnswer(pr);
			out = response.getWriter();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.write(JsonUtil.arrToJson(arr));
			out.close();
		}
		
		return NONE;
	}
	
	
	
	private  PcResult pr;

	@Autowired
	private IPcResultService pcResultService;
	
 
	
}
