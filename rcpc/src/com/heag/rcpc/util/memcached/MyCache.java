package com.heag.rcpc.util.memcached;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * @author wn
 *
 */
public class MyCache {
	private static MemCachedClient client = null;
	public MemCachedClient getInstance(){
		if(client==null){
			client = new MemCachedClient();
			 // 设置缓存服务器列表，当使用分布式缓存的时，可以指定多个缓存服务器。这里应该设置为多个不同的服务。
			String [] addr ={"127.0.0.1:11211"};  
			// 设置服务器权重 
			Integer [] weights = {3};  
			SockIOPool pool = SockIOPool.getInstance();
		   	pool.setServers(addr);  
	        pool.setWeights(weights); 
	        pool.setServers(addr);  
	        pool.setWeights(weights);  
	        pool.setInitConn(5);  
	        pool.setMinConn(5);  
	        pool.setMaxConn(200);  
	        pool.setMaxIdle(1000*30*30);  
	        pool.setMaintSleep(30);  
	        pool.setNagle(false);  
	        pool.setSocketTO(3000);  
	        pool.setSocketConnectTO(0);  
	        pool.initialize();  
	        client.set("state", "OK");
	        //client.setCompressEnable(true);  
	        //client.setCompressThreshold(1000*1024); 
		}
		return client;
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {  
		String str1="ssssssssssdfv";
		String str2="ssssssssssdfv"+ new String("dfv");
		System.out.println(str1.replaceFirst("d", "cc"));
		System.out.println(str1.replace("d", "cc"));
		System.out.println(str1==str2);
		
		int i =0 ;
		for (i++; i++<10; i++) {
			System.out.println(++i);
		}
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(d));
		Calendar cr = Calendar.getInstance();
		System.out.println(cr.get(Calendar.DAY_OF_MONTH));
		System.out.println(cr.get(Calendar.DAY_OF_YEAR));
		System.out.println(cr.get(Calendar.YEAR));
		System.out.println(cr.get(Calendar.MONTH)+1);
		System.out.println(cr.get(Calendar.DATE));
		System.out.println(cr.get(Calendar.WEEK_OF_MONTH));
		System.out.println(cr.getTimeZone());
		System.out.println(cr.getTime());
		Calendar cr1 = Calendar.getInstance();
		cr.setTime(new Date("2016/07/02"));
		System.out.println("===" +cr.compareTo(cr1));
        //将数据放入缓存  
		MemCachedClient client = new MyCache().getInstance();
		client.set("test2","test2");
        //将数据放入缓存,并设置失效时间  
        Date date=new Date(2000);  
        client.set("test1","test1", date);  
        //获取缓存数据         
        System.out.println(client.get("test1")); 
        System.out.println(client.get("test2")); 
        System.out.println("进入休眠4s"); 
        Thread.sleep(4000);
        System.out.println(client.get("test1")); 
        System.out.println(client.get("test2")); 
	}
}
