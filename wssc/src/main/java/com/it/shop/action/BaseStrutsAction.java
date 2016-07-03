package com.it.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.it.shop.service.AccountService;
import com.it.shop.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//公共基础action 继承ActionSupport 和   实现相应的接口(RequestAware,SessionAware,ApplicationAware)，ModelDriven
@Controller("baseStrutsAction")
@Scope("prototype")
public class BaseStrutsAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{


	//域对象  
	protected  Map<String, Object> request;  
	protected  Map<String, Object> session;  
	protected  Map<String, Object> application;

	public void setRequest(Map<String, Object> request) {
		this.request = request;  
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;  	
	}
	public void setApplication(Map<String, Object> application) {
		this.application = application;  	
	}
	//ModelDriven 泛型接收对象
	protected T model; 	
	public T getModel(){
		//这里通过解析传进来的T来new一个对应的instance  
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class)type.getActualTypeArguments()[0];  
		try {
			 model = (T)clazz.newInstance();  
		}catch (Exception e) {  
			throw new RuntimeException(e);  
		}
		return model;
	}	
	
	//service对象 
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;    

}