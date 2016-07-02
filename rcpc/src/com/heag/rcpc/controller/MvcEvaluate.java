package com.heag.rcpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heag.rcpc.model.PcEvaluate;
import com.heag.rcpc.service.IPcEvaluateService;
@Controller
@RequestMapping("/eva")
public class MvcEvaluate {
	@Autowired
	private IPcEvaluateService pcEvaluateService;	
	@RequestMapping(value="/getEname/{eid}",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody String getEname(@PathVariable("eid")String eid){
		String reString="";
		try {
			PcEvaluate pe = pcEvaluateService.selectByPrimaryKey(Integer.valueOf(eid));
			reString = pe.getEname();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return reString;
		
	} 
}
