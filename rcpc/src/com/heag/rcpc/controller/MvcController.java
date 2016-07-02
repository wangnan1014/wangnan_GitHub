package com.heag.rcpc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heag.rcpc.model.PcAskinfo;
import com.heag.rcpc.service.IPcAskinfoService;
import com.heag.rcpc.util.Email;
//例子
@Controller
@RequestMapping("/wn")
public class MvcController {
	//返回cc到页面
	@Autowired
	private IPcAskinfoService pcAskinfoService;	
	@Autowired
	private Email email;
	@RequestMapping(value="/hello",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public @ResponseBody String info() throws MessagingException{
		Map<String, String> map = new HashMap();
		map.put("wangnan1", "1");
		map.put("wangnan2", "2");
		map.put("wangnan3", "3");
		map.put("wangnan4", "4");
		List<String> ar =new ArrayList<String>();
		ar.add("wangnan");
		ar.add("wangnan1");
		email.sendEmail("呵呵", "<font size='58'>你好</font>", "niuxiumei@heag.com");
		return 	"cc";
		
	}
	//返回/WEB-INF/jsp/cc.jsp
	@RequestMapping("/hello1")
	public String info1(){
		return "cc";
		
	}	
}
