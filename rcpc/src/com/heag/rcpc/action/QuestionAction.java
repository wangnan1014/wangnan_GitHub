package com.heag.rcpc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;


import com.heag.rcpc.model.PcOptions;
import com.heag.rcpc.model.PcOptionsExample;
import com.heag.rcpc.model.PcQuestion;
import com.heag.rcpc.service.IPcOptionsService;
import com.heag.rcpc.service.IPcQuestionService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.javac.resources.compiler;


/**
 * 
 * @author wn
 * 用于题目信息
 */
public class QuestionAction extends ActionSupport {
	private static final Logger logger=Logger.getLogger("report.debug");
	HttpServletResponse res = ServletActionContext.getResponse();  
	HttpServletRequest req = ServletActionContext.getRequest();
	private  PcQuestion pq;
	private  PcOptions po;
	@Autowired
	private IPcQuestionService pcQuestionService;
	@Autowired
	private IPcOptionsService pcOptionsService;
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	//提取题目信息和选项信息
	public String getDataList() throws Exception {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = res.getWriter();
		String aid =req.getParameter("aid");
		if(!"".equals(aid)&&aid!=null){
			pq = new PcQuestion();
			pq.setAid(new Integer(aid));
			ArrayList<PcQuestion> arr= pcQuestionService.selectQuestionAndOptions(pq);
			out.write(JsonUtil.arrToJson(arr));
	    	out.close();
    	}else{
			out.write("0");
	    	out.close();
    	}		
		return NONE;
	}
	//对新增目信息和选项信息进行保存（不在同事务）
	public String doSave(){
		res.setCharacterEncoding("UTF-8");
		String[] e_options = req.getParameterValues("e_option");
		String e_qname = req.getParameter("e_qname");
		String aid = req.getParameter("aid");
		PrintWriter out = null;
		String result="0";
		try {
			out = res.getWriter();
			//题目存储
			pq = new PcQuestion();
			pq.setAid(new Integer(aid));
			pq.setCreatedate(new Date());
			pq.setIsdelete(ConstantsUtil.NOTDELETED);
			pq.setQname(e_qname);
			pq.setQtype(new Integer(1));
			pcQuestionService.insertSelective(pq);
			//选项存储
			po = new PcOptions();
			po.setCreatedate(new Date());
			po.setIsdelete(ConstantsUtil.NOTDELETED);
			po.setQid(pq.getQid());
			for(String ops:e_options){
				po.setOoption(ops);
				pcOptionsService.insertSelective(po);
			}
			result="1";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
		}
		return NONE;
	}
	//删除题目和选项
	public String doDelete() throws IOException{
		res.setCharacterEncoding("UTF-8");
		String qid = req.getParameter("qid");
		String result="0";
		PrintWriter out = null;
		try {
			out = res.getWriter();
			pq = new PcQuestion();
			pq.setQid(new Integer(qid));
			pq.setIsdelete(ConstantsUtil.DELETED);
			
			String qstr = pcQuestionService.updateByPrimaryKeySelective(pq);  
			po = new PcOptions();
			po.setIsdelete(ConstantsUtil.DELETED);
			PcOptionsExample poe = new  PcOptionsExample();
			com.heag.rcpc.model.PcOptionsExample.Criteria Criteria =poe.createCriteria();
			Criteria.andQidEqualTo(new Integer(qid));
			String ostr = pcOptionsService.updateByExampleSelective(po,poe);
			result = "1";
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
		}
		return NONE;
	}
	//更新分段分类内容
	public String doBulidContext(){
		res.setCharacterEncoding("UTF-8");
		String qid = req.getParameter("qid");
		String remark = req.getParameter("context");
		PrintWriter out = null;
		String result="0";
		if(!"".equals(qid)&&qid!=null){
		try {
			out = res.getWriter();
			//题目remark 更新
			pq = new PcQuestion();
			pq.setQid(new Integer(qid));
			pq.setRemark(remark);
			pcQuestionService.updateByPrimaryKeySelective(pq);
			result="1";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
		}}
		return NONE;
	}
	//获取题目分段分类
	public String getContextDataList(){
		res.setCharacterEncoding("UTF-8");
		String aid = req.getParameter("aid");
		PrintWriter out = null;
		String result="0";
		ArrayList<PcQuestion> arrayList=null;
		if(!"".equals(aid)&&aid!=null){
		try {
			out = res.getWriter();
			//获取题目remark 
			arrayList = (ArrayList<PcQuestion>) pcQuestionService.selectQuestionContext(new Integer(aid));
			result="1";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if("1".equals(result)){
				out.write(JsonUtil.arrToJson(arrayList));	
			}else{
				out.write(result);	
			}
			out.close();
		}}
		return NONE;
		
		
	}
}
