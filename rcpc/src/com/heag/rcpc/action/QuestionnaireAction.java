package com.heag.rcpc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.awt.RepaintArea;
import sun.security.krb5.internal.PAEncTSEnc;

import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.model.PcAskinfoExample;
import com.heag.rcpc.model.PcEvaluateRelation;
import com.heag.rcpc.model.PcResult;
import com.heag.rcpc.service.IPcAskinfoService;
import com.heag.rcpc.service.IPcEvaluateRelationService;
import com.heag.rcpc.service.IPcResultService;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.istack.internal.FinalArrayList;


public class QuestionnaireAction extends ActionSupport {
	private static final Logger logger=Logger.getLogger("report.debug");
	private  PcAskinfo pa;
	@Autowired
	private IPcAskinfoService pcAskinfoService;
	@Autowired
	private IPcResultService pcResultService;
	@Autowired
	private IPcEvaluateRelationService pcEvaluateRelationService;
	HttpServletResponse res = ServletActionContext.getResponse();  
	HttpServletRequest req = ServletActionContext.getRequest(); 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	//得到问卷基本数据
	public String getDataList() throws Exception {

		res.setCharacterEncoding("UTF-8");
		String uid = req.getParameter("uid");
		PrintWriter out = null;
		String result="0";
		out = res.getWriter();
		PcAskinfoExample pae = new PcAskinfoExample();
		com.heag.rcpc.model.PcAskinfoExample.Criteria criteria = pae.createCriteria();
		criteria.andUidEqualTo(new Integer(uid));
		criteria.andIsdeleteEqualTo(ConstantsUtil.NOTDELETED);
		ArrayList<PcAskinfo> arr= pcAskinfoService.selectByExample(pae);
		out.write(JsonUtil.arrToJson(arr));
    	out.close();		
		return NONE;
	}
	//得到问卷详细数据
	public String getAskinfoAndQuestionAndOption(){
		res.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		ArrayList<PcAskinfo> arr=null;
		String result="0";
		String aid = req.getParameter("aid");
		try {
			out = res.getWriter();
			pa = new PcAskinfo();
			pa.setAid(new Integer(aid));
			pa.setIsopen(new Byte("0"));
			pa.setIsdelete(new Byte("0"));
			arr= pcAskinfoService.getAskinfoAndQuestionAndOption(pa);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.write(JsonUtil.arrToJson(arr));
			out.close();
		}
		
		return NONE;
	}
	public String addAskInfo()  {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out =null;
		String result="0";
		try {
			pa = new PcAskinfo();
			pa.setAtitle(req.getParameter("atitle"));
			pa.setAdescribe(req.getParameter("adescribe"));
			pa.setUname(req.getParameter("uname"));
			pa.setUid(new Integer(req.getParameter("uid")));
			pa.setAtype(new Byte("1"));
			pa.setIsopen(new Byte("0"));
			pa.setIsdelete(new Byte("0"));
			pa.setCreatedate(new Date());		
			result =pcAskinfoService.insertSelective(pa);
			out = res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
			return NONE;			
		}
	}
	
	public String editAskInfo() throws Exception {
		PrintWriter out = res.getWriter();
		String result="0";		
		if(req.getParameter("aid")!=null&&!"".equals(req.getParameter("aid"))){
			pa = new PcAskinfo();
			pa.setAtitle(req.getParameter("atitle"));
			pa.setAdescribe(req.getParameter("adescribe"));
			pa.setAid(new Integer(req.getParameter("aid")));			
			result =pcAskinfoService.updateByPrimaryKeySelective(pa);
		}
		out.write(result);
		out.close();
		return NONE;		

	}
	public String deleteAskInfo() throws Exception {
		PrintWriter out = res.getWriter();
		String result="0";
		if(req.getParameter("aid")!=null&&!"".equals(req.getParameter("aid"))){
			pa = new PcAskinfo();
			pa.setAid(new Integer(req.getParameter("aid")));
			pa.setIsdelete(ConstantsUtil.DELETED);
			result =pcAskinfoService.updateByPrimaryKeySelective(pa);
		}
		out.write(result);
		out.close();
		return NONE;
	}
	//提交问卷答案
	/**
	 * @return result
	 */
	public String doAskInfo()  {
		PrintWriter out =null;
		String result="0";
		try {
			out = res.getWriter();
			String aid =req.getParameter("aid");
			String eid =req.getParameter("eid");

			String id =req.getParameter("id");
			String evaluator =req.getParameter("evaluator");
			String[] qidVals = req.getParameterValues("qid");
			Map pars = req.getParameterMap();
			//if(isAnswer(new Integer(aid), new Integer(eid), new Integer(id), evaluator)){//如果没有答题
			if(!getAnswerState(new Integer(aid), new Integer(eid), new Integer(id), evaluator)){//得到评估人答题状态(先这样暂定， 以后再来详细判断到aid eid 和 id)
				//记录答案
				result = pcResultService.insertSelective(new Integer(aid), new Integer(eid), new Integer(id), evaluator, qidVals, pars);
				//更改评估人问卷是否答题的状态
				if(!"0".equals(result)){ 
					PcEvaluateRelation per = new PcEvaluateRelation();
					per.setId(new Integer(id));
					per.setCompletestatus("1");
					per.setCompletetime(new Date());
					pcEvaluateRelationService.updateByPrimaryKeySelective(per);
				}
			}else{
				result="2";//已经打过题，不能再提交
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();			
		}
		return NONE;
	}
	//判断是否存在答题数据
	/**
	 * @param aid
	 * @param eid
	 * @param id
	 * @param evaluator
	 * @return false 没有答题 ; true 已经答题
	 */
	public boolean isAnswer(Integer aid,Integer eid,Integer id,String evaluator){
		int result =0;
		result = pcResultService.countByExample(aid,eid,id,evaluator);
		if(result==1){
			return false;
		}else{
			return true;
		}
	}
	//得到评估人答题状态
	/**
	 * @param aid
	 * @param eid
	 * @param id
	 * @param evaluator
	 * @return false 未答过题  true 已答过题
	 */
	public boolean getAnswerState(Integer aid,Integer eid,Integer id,String evaluator){
		int result =0;
		result = pcEvaluateRelationService.countByExample(aid,eid,id,evaluator);
		if(result==1){
			return false;
		}else{
			return true;
		}
	}
	//关闭问卷
	/**
	 * @param aid

	 * @return 0 关闭失败  1 关闭成功
	 */	
	public String updateAskinfoState(){
		String aid = req.getParameter("aid");
		String result = "0";
		PrintWriter out =null;
		try {
			out = res.getWriter();
		if(req.getParameter("aid")!=null&&!"".equals(req.getParameter("aid"))){
			pa = new PcAskinfo();
			pa.setIsopen(new Byte("1"));
			pa.setAid(new Integer(req.getParameter("aid")));			
			result =pcAskinfoService.updateByPrimaryKeySelective(pa);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.write(result);
			out.close();
		}		
		return NONE;
	}
}
