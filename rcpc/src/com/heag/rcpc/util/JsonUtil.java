package com.heag.rcpc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.heag.rcpc.model.RpProject;

public class JsonUtil {
	//给project list页面输出的
	public static String arrToJsonForProject(List list){
		JsonConfig jsonConfig = new JsonConfig();  
		JsonConfigUtil JcUtil = new JsonConfigUtil(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, JcUtil);  
		jsonConfig.setJsonPropertyFilter(JcUtil);					
		JSONObject jo = new JSONObject();
		jo.put("data", JSONArray.fromObject(list,jsonConfig));		
		return jo.toString().replaceAll("IContractid","iContractid").replaceAll("OContractid", "oContractid");
	}
	//给 one project  页面输出调用
	public static String objToJson(RpProject rp){
		JsonConfig jsonConfig = new JsonConfig();  
		JsonConfigUtil JcUtil = new JsonConfigUtil(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, JcUtil);  
		//jsonConfig.setJsonPropertyFilter(JcUtil);					
		Map map = new HashMap();
		map.put("data", rp);		
		return JSONObject.fromObject(map,jsonConfig).toString().replaceAll("IContractid","iContractid").replaceAll("OContractid", "oContractid");
	}
	//给  控件 调用
	public static String objToJson(Map<String, ArrayList> m){
		JsonConfig jsonConfig = new JsonConfig();  
		JsonConfigUtil JcUtil = new JsonConfigUtil(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, JcUtil);  
		jsonConfig.setJsonPropertyFilter(JcUtil);					
		JSONObject jo = new JSONObject();
		for(Map.Entry<String, ArrayList> entry : m.entrySet()){ 
			jo.put(entry.getKey(), JSONArray.fromObject(entry.getValue()));	
		}
		return jo.toString();
	}	
	//去空和时间字符化给常规页面输出调用
	public static String arrToJson(List list){
		JsonConfig jsonConfig = new JsonConfig();  
		JsonConfigUtil JcUtil = new JsonConfigUtil(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, JcUtil);  
		jsonConfig.setJsonPropertyFilter(JcUtil);					
		JSONObject jo = new JSONObject();
		jo.put("data", JSONArray.fromObject(list,jsonConfig));		
		return jo.toString();
	}
	//时间转字符
	public static String arrToJsonForDate(List list){
		JsonConfig jsonConfig = new JsonConfig();  
		JsonConfigUtil JcUtil = new JsonConfigUtil(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, JcUtil);  		
		JSONObject jo = new JSONObject();
		jo.put("data", JSONArray.fromObject(list,jsonConfig));		
		return jo.toString();
	}	
	//List<Map>转json
	public static String toJson(List<Map> list){
		JSONObject jo = new JSONObject();
		jo.put("data", JSONArray.fromObject(list));		
		return jo.toString();
	}	
	//map转json 
	public static String mapToJson(Map map){
		JsonConfig jsonConfig = new JsonConfig();  
		JsonConfigUtil JcUtil = new JsonConfigUtil(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, JcUtil);  	
		return JSONObject.fromObject(map,jsonConfig).toString();
		
	}	
}
