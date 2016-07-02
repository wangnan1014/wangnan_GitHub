package com.heag.rcpc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.model.PcEvaluate;
import com.heag.rcpc.model.PcEvaluateRelation;
import com.heag.rcpc.model.PcEvaluateRelationExample;
import com.heag.rcpc.model.PcEvaluateRelationExample.Criteria;
import com.heag.rcpc.service.IPcEvaluateRelationService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EvaluateRelationAction extends ActionSupport{
	
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
		ArrayList<PcEvaluateRelation> evalutorArr = null;
		try {
			int aid= Integer.parseInt(request.getParameter("aid"));
			int eid= Integer.parseInt(request.getParameter("eid"));
			PcEvaluateRelationExample pere = new PcEvaluateRelationExample();
			//pee.createCriteria().andAidEqualTo(aid);
			//pee.createCriteria().andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);
			Criteria criteria = pere.createCriteria();
			criteria.andAidEqualTo(aid);
			criteria.andEidEqualTo(eid);
			criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);
			
			evalutorArr=pcEvaluateRelationService.selectByExample(pere);
			 
			 
			out = response.getWriter();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dataListStr=JsonUtil.arrToJson(evalutorArr);
		 
		out.write(dataListStr);
    	out.close();		
		return NONE;
		
	}
	
	
	@SuppressWarnings("finally")
	public String addEvaluator(){
		
		/**
		 * 增加人员
		 */
		 
		response.setCharacterEncoding("UTF-8");
		Date nowDate=new Date();
		PrintWriter out =null;
		String result="0";
		try{
			
			per = new PcEvaluateRelation();
			int aid= Integer.parseInt(request.getParameter("aid"));
			int eid= Integer.parseInt(request.getParameter("eid"));
			per.setAid(aid);
			per.setEid(eid);
			per.setRelation(request.getParameter("relation"));
			per.setEvaluator(request.getParameter("evaluator"));
			per.setEmail(request.getParameter("email"));
			per.setRemark(request.getParameter("remark"));
			per.setEmailstatus("0");//0表示未处理
			per.setCompletestatus("0");//0表示未处理
			per.setCreatedate(nowDate);
			per.setIsdelete(ConstantsUtil.NOTDELETED);
			
			result=pcEvaluateRelationService.insertSelective(per);
		     
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
	public String delEvaluator(){
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
			PcEvaluateRelationExample pere = new PcEvaluateRelationExample();
			pere.createCriteria().andIdIn(idList);
		
			PcEvaluateRelation per=new PcEvaluateRelation();
			per.setIsdelete(ConstantsUtil.DELETED);
		
			result=pcEvaluateRelationService.updateByExampleSelective(per, pere);
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
	
	
	public String updateEvaluatorById(){
		response.setCharacterEncoding("UTF-8");
		 
		PrintWriter out =null;
		int result=0;
		try{
			per = new PcEvaluateRelation();
			per.setId(Integer.parseInt(request.getParameter("id")));
			per.setRelation(request.getParameter("relation"));
			per.setEvaluator(request.getParameter("evaluator"));
			per.setEmail(request.getParameter("email"));
			//per.setRemark(request.getParameter("remark"));
			
			result=pcEvaluateRelationService.updateByPrimaryKeySelective(per);
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
	 * 获得回收进度信息
	 * @return
	 */
	public String getPrograssDataList(){
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		String aid= request.getParameter("aid");
		List<Map<String, String>> evalutorArr  = null;
		try {
			
			out = response.getWriter();
			evalutorArr=pcEvaluateRelationService.selectEvaluateAndEvaluateRelationByAid(new Integer(aid));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			String dataListStr=JsonUtil.arrToJson(evalutorArr);
			out.write(dataListStr);
	    	out.close();		
			return NONE;
		}

	}	 
	
	
	
	private PcEvaluateRelation per;
	@Autowired
	private IPcEvaluateRelationService pcEvaluateRelationService;
	
	

}
