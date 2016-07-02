package com.heag.rcpc.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.mapper.PcAskinfoMapper;
import com.heag.rcpc.util.ExcelUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CollectAction extends ActionSupport {
	HttpServletResponse response = ServletActionContext.getResponse();  
	HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	private PcAskinfoMapper pcAskinfoMapper;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	public String collectToExcel() throws Exception {
		Map<String,Integer> map = new HashMap<String, Integer>();
		Integer aid =new Integer(request.getParameter("aid"));
		Integer eid =new Integer(request.getParameter("eid"));
		Integer isBCollect = new Integer(request.getParameter("isBCollect"));
		
		String title ="t1.xls";
		map.put("aid", aid);
		map.put("eid", eid);
		if(isBCollect==0){//题目汇总
			map.put("isBCollect", null);
			title="q.xls";
		}else{//类别汇总
			map.put("isBCollect", isBCollect);
			title="big.xls";
		}
		
		List<Map<String,String>> l1 = pcAskinfoMapper.getCollectDate(map);

		ExcelUtil eu = new ExcelUtil();
		eu.outputExcel(title, l1,new String[]{"类型","上级","平级","下级","自己"});
		return NONE;
	}	
}

