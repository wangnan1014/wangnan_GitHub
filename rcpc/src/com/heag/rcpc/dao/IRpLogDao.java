package com.heag.rcpc.dao;

import com.heag.rcpc.model.RpLog;
import com.heag.rcpc.model.RpLogExample;

import java.util.List;

/**
 * Created by Administrator on 2015-6-23 0023.
 */
public interface IRpLogDao {

    /**
     * 新增一条日志
     * @param log
     * @return
     */
    public long insert(RpLog log);

    /**
     * 查询日志
     * @param example
     * @return
     */
    public List<RpLog> selectByExample(RpLogExample example);
    /**
     * 删除记录 (可多条)
     * @param int
     * @return 成功
     */
    public int deleteByList(String keyVals);
    /**
     * 查询总数
     * @param RpLogExample
     * @return int
     */ 
    public int countByExample(RpLogExample rle);    
}
