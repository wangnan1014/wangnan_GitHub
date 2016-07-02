package com.wn;

import java.util.Date;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.shop.model.Category;
import com.it.shop.service.CategoryService;
import com.it.shop.service.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")  
public class SSHTest  {

	@Resource
	private Date date;
	@Test //测试Spring IOC的开发环境
	public void springIoc(){
		System.out.println(date); 
	}
	@Autowired
	private CategoryService categoryService; 
	@Test  //测试Hibernate的开发环境，因为没有整合，可以直接new  
	public void hihernateAndSpring() {  
		Category category = new Category("王楠",true);
		categoryService.save(category);
		category.setId(1);
		category.setType("休闲裤子");
		categoryService.update(category);
	}
}
