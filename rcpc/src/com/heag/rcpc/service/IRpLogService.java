package com.heag.rcpc.service;

import com.heag.rcpc.model.RpLog;
import com.heag.rcpc.model.RpLogExample;

import java.util.List;

/**
 * Created by Administrator on 2015-6-23 0023.
 */
public interface IRpLogService {

    /**
     * 新增一条日志信息
     * @param uid 用户id 必填
     * @param username 用户名 必填
     * @param companyid 公司id
     * @param companyname 公司名
     * @param deptid 部门id
     * @param deptname 部门名
     * @param action 操作行为
    1 登录
    2 登出
    3 查询
    4 新增
    5 修改
    6 删除
    7 导出数据
     * @param page 涉及页面
     * @param tablename 涉及的数据库表
     * @param dataid 涉及的数据库表记录主键
     * @param dataname 涉及的字段名
     * @param beforeupdate 更新前数据
     * @param afterupdate 更新后数据
     * @return
     */

    public Boolean insert(Integer uid,String username,Integer companyid,String companyname,
                          Integer deptid,String deptname,Integer action,String page,String tablename,
                          String dataid,String dataname,String beforeupdate,String afterupdate);

    public List<RpLog> selectList(RpLogExample rle);
    
    public int deleteByList(String keyVals);   
    /**
     * 查总数
     * */
    public int countByExample(RpLogExample rle);
    
    

}
