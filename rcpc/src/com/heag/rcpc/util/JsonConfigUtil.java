package com.heag.rcpc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;

public class JsonConfigUtil  implements  JsonValueProcessor,PropertyFilter  {
	private String format ="yyyy-MM-dd";
	private String format1 ="yyyy-MM-dd HH:mm:ss";
 
	      
	public JsonConfigUtil() {  
        super();  
    } 
    public JsonConfigUtil(String format) {  
        super();  
        this.format = format;  
    }
    
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		return process(arg0);  
	}

	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		// TODO Auto-generated method stub
		return process(arg1);  
	}
    
    private Object process(Object value){  
        //date 改 字符类型
    	if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format1,Locale.CHINA);    
            return sdf.format(value); 
        }    
        return value == null ? "" : value.toString();    
    }
    //过滤空字符
	public boolean apply(Object arg0, String arg1, Object arg2) {
		if(arg2==null){
			return true;
		}else{
			return false;
		}
	}
    


}