package com.heag.rcpc.util;

/**
 * 常用系统常量
 * Created by Administrator on 2015-6-24 0024.
 */

/**
  permission表ptype约定取值定义：
 1 页面查看权限
 2 数据查询权限
 3 新增权限
 4 修改权限
 5 删除权限
 6 导数据权限
 7 特殊权限
 8 所有权限
 */

/**
 * 日志表log表action约定取值定义：
 1 登录
 2 登出
 3 查询
 4 新增
 5 修改
 6 删除
 7 导出数据
 */

/**
 * 用户表user表
 * 
 * */

public class ConstantsUtil {
	public static final String DATEFOMART="yyyy-MM-dd";//
    public static final String ENCRYPTDATE="20150626102107";//加密盐值 

    public static final Byte DELETED=1;//已删除
    public static final Byte NOTDELETED=0;//未删除

    public static final Integer PVIEW=1; //页面查看权限
    public static final Integer PDATASELECT=2; //数据查询权限
    public static final Integer PDATAINSERT=3; //数据新增权限
    public static final Integer PDATAMODIFY=4; //数据修改权限
    public static final Integer PDATADELETE=5; //数据删除权限
    public static final Integer PDATAEXPORT=6; //导数据权限
    public static final Integer PSPECIAL=7; //特殊权限
    public static final Integer PALL=8; //所有权限 


    public static final Integer LLOGIN=1;//登录
    public static final Integer LLOGOUT=2; //登出
    public static final Integer LSELECT=3; //查询
    public static final Integer LINSERT=4; //新增
    public static final Integer LMODIFY=5; //修改
    public static final Integer LDELETE=6; //删除
    public static final Integer LEXPORT=7; //导出数据
    //用户表user表
    public static final String INITPASSWOER="888888";//初始密码
    
    //列表 checkbox显示开关 //暂时放这
    public static final boolean CHECKBOXOPEN = false; 
}
