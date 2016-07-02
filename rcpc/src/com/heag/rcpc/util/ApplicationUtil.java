package com.heag.rcpc.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ApplicationUtil implements ApplicationContextAware{
	     private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");  

	     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	         //ApplicationUtil.applicationContext = applicationContext;
	    	 ApplicationUtil.applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	     }
	     public static Object getBean(String name){
	         return applicationContext.getBean(name);
	     }
	 }