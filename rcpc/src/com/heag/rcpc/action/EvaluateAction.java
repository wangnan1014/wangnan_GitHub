package com.heag.rcpc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.model.PcEvaluate;
import com.heag.rcpc.model.PcEvaluateExample;
import com.heag.rcpc.model.PcEvaluateExample.Criteria;

import com.heag.rcpc.service.IPcEvaluateService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EvaluateAction extends ActionSupport{
	
	private static final Logger logger=Logger.getLogger("report.debug");
	HttpServletResponse response = ServletActionContext.getResponse();  
	HttpServletRequest request = ServletActionContext.getRequest();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	/**
	 * 
	 * 獲取所有數據
	 * @return
	 */
	public String getDataList(){
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		//String result="0";
		ArrayList<PcEvaluate> evaluteArr = null;
		try {
			int aid= Integer.parseInt(request.getParameter("aid"));
			PcEvaluateExample pee = new PcEvaluateExample();
			//pee.createCriteria().andAidEqualTo(aid);
			//pee.createCriteria().andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);
			Criteria criteria = pee.createCriteria();
			criteria.andAidEqualTo(aid);
			criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);
			
			evaluteArr=pcEvaluateService.selectByExample(pee);
			 
			out = response.getWriter();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dataListStr=JsonUtil.arrToJson(evaluteArr);
		out.write(dataListStr);
    	out.close();		
		return NONE;
		
	}
	
	
	@SuppressWarnings("finally")
	public String addEvaluate(){
		
		/**
		 * 增加评估人员
		 */
		 
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		String result="0";
		try{
			pe = new PcEvaluate();
			int aid= Integer.parseInt(request.getParameter("aid"));
			pe.setAid(aid);
			pe.setEname(request.getParameter("ename"));
			pe.setDname(request.getParameter("dname"));
			pe.setEmail(request.getParameter("email"));
			pe.setRemark(request.getParameter("remark"));
			pe.setIsdelete(ConstantsUtil.NOTDELETED);
			pe.setNum("0");
			pe.setCompletenum("0");
			
			result=pcEvaluateService.insertSelective(pe);
		    
			out = response.getWriter();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
			return NONE;			
		}
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String delEvaluate(){
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		int result=0;
		try{
			String delIgdStr=request.getParameter("delIdStr");
			 
			ArrayList<Integer> idList= new ArrayList<Integer>();
			String[] ids=delIgdStr.split(",");
			for(int i=0;i<ids.length;i++){
				idList.add(Integer.parseInt(ids[i]));
			}
			PcEvaluateExample pee = new PcEvaluateExample();
			pee.createCriteria().andEidIn(idList);
		
			PcEvaluate pe=new PcEvaluate();
			pe.setIsdelete(ConstantsUtil.DELETED);
		
			result=pcEvaluateService.updateByExampleSelective(pe, pee);
			out = response.getWriter();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
			return NONE;			
		}
		
	}
	
	
	public String updateEvaluateById(){
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		int result=0;
		try{
			pe = new PcEvaluate();
			pe.setEid(Integer.parseInt(request.getParameter("eid")));
			pe.setEname(request.getParameter("ename"));
			pe.setDname(request.getParameter("dname"));
			pe.setEmail(request.getParameter("email"));
			pe.setRemark(request.getParameter("remark"));
			result=pcEvaluateService.updateByPrimaryKeySelective(pe);
			out = response.getWriter();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
			return NONE;			
		}
		
	}
	
	
	/*public String delEvaluate(){
		response.setCharacterEncoding("UTF-8");
		int result=0;
		String delIgdStr=request.getParameter("delIdStr");
		ArrayList<Integer> idList= new ArrayList<Integer>();
		String[] ids=delIgdStr.split(",");
		for(int i=0;i<ids.length;i++){
			idList.add(Integer.parseInt(ids[i]));
		}
		for(int i=0;i<idList.size();i++){
			System.out.println("=========="+idList.get(i));
		}
		PcEvaluateExample pee = new PcEvaluateExample();
		pee.createCriteria().andEidIn(idList);
		result=pcEvaluateService.deleteByExample(pee);
		
		 
		return null;
		
		
	}*/
	
	/**
	 * 
	 * 获取pcevaluate的Ename
	 * @return
	 */
	public String getEname(){
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		//String result="0";
		String eid = request.getParameter("eid");
		
		try {
			
			pe = pcEvaluateService.selectByPrimaryKey(new Integer(eid));
			 
			out = response.getWriter();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(pe.getEname());
    	out.close();		
		return NONE;
		
	}	
	
	
	
	
	
	
	
	private PcEvaluate pe;
	@Autowired
	private IPcEvaluateService pcEvaluateService;
	
	

}