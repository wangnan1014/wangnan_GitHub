package com.it.shop.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.it.shop.model.Category;
import com.it.shop.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseStrutsAction<Category>{
	
	public String update() {  
		System.out.println("----update----");
		System.out.println(categoryService);
		categoryService.update(model); 
		return "index";
	}
	
	public String save() { 
		System.out.println("----save----");  
		System.out.println(categoryService);
		if(model!=null) categoryService.save(model);
		return "out";
	}
	
	public String query() {  
		List<Category> categoryList= categoryService.query();
	    request.put("categoryList", categoryList);   
	    session.put("categoryList", categoryList);   
        application.put("categoryList", categoryList);   
        return "index";  
    }  
	


	
}
