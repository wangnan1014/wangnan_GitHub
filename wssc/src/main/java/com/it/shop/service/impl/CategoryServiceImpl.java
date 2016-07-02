package com.it.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.shop.model.Category;
import com.it.shop.service.CategoryService;
import com.it.shop.utils.HibernateSessionFactory;

/* 
* 只要添加CategoryService本身需要的新的方法即可，公共方法已经在BaseService中了 
*/  
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	/* 
     * 如果不要共同的方法只需实现CategoryService接口中新增的方法即可，公共方法已经在BaseServiceImpl中实现了 
     */
	
}
