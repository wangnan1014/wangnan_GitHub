package com.heag.rcpc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.heag.rcpc.service.IRpProjectService;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2015-7-7 0007.
 */
public class MapReportAction extends ActionSupport {

    private static final Logger logger=Logger.getLogger("report.debug");

    private IRpProjectService rpProjectService;

    private HttpServletRequest req = ServletActionContext.getRequest();       
    
    private HttpSession session = ServletActionContext.getRequest().getSession();  
    
    private HttpServletResponse res = ServletActionContext.getResponse() ;
    
    public String execute() throws Exception {

        logger.info("MapReportAction is called");

        return SUCCESS;
    }
    /**
     * 获取营销数据报表
     * @return
     * @throws IOException 
     */
    public String getProjectReport() throws IOException{
    	res.setCharacterEncoding("UTF-8");
    	req.setCharacterEncoding("UTF-8");
    	PrintWriter out = res.getWriter();
    	String startDate=req.getParameter("startDate");
    	String endDate=req.getParameter("endDate");
    	String typeName=req.getParameter("typeName");
    	String v_arr =req.getParameter("v_arr");
    	Map m= new HashMap();
    	m.put("startDate", startDate);
    	m.put("endDate", endDate);
    	if("0".equals(typeName)){
    		typeName="region";
    	}else{
    		typeName="province";
    	}
    	m.put("typeName", typeName);
    	//String values = "'" + v_arr.replaceAll(",", "','")+"'";
    	//m.put("v_arr", "'"+v_arr.replaceAll(",", "','")+"'");
    	m.put("v_arr", v_arr.split(",",-1));
    	ArrayList<Map> arr = rpProjectService.selectProjectMapReport(m);
    	out.print(JsonUtil.toJson(arr));	
        return NONE;
    }

    public void setRpProjectService(IRpProjectService rpProjectService) {
        this.rpProjectService = rpProjectService;
    }


}
