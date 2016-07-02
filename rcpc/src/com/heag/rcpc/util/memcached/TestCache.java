package com.heag.rcpc.util.memcached;

import java.util.HashMap;
import java.util.Map;

import sun.tools.tree.VarDeclarationStatement;

import com.danga.MemCached.MemCachedClient;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestCache {
	public static void main(String[] args) {  
		MemCachedClient mCache  = new MyCache().getInstance();
		Map<String, String> m = new HashMap<String, String>();
		m.put("a1", "wang");
		m.put("a2", "wang");
		m.put("a3", "wang");
		mCache.set("wangnan", m);
		mCache.set("state", "弄在");
		System.out.println(mCache.get("state")); 
		System.out.println(mCache.get("wangnan")); 
		int x = 5;//酒
		int y = 0;//盖子
		int z = 0;//空瓶
		int h = 0;//喝掉
		while(x>0){
				h++;
				x--;//喝掉1
				y++;//盖子+1
				z++;//空瓶+1
				if(y>=4){//盖子换酒
					y-=4;
					x++;
				}				
				if(z>=2){//空瓶换酒
					z-=2;
					x++;
				}
				if(y>=2&&z>=1){
					y-=2;
					z--;
					x++;
				}
		}
		System.out.println(x+" " +y+" "+ z +" "+ h);
	}
}
