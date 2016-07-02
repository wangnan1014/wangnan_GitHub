package com.heag.rcpc.model;

import java.util.Date;

public class RpLog {
    private Long lid;

    private Integer uid;

    private String uname;

    private Integer cid;

    private String cname;

    private Integer deptid;

    private String deptname;

    private Byte action;

    private String actiondesc;

    private String page;

    private String tablename;

    private String dataid;

    private String dataname;

    private String beforeupdate;

    private String afterupdate;

    private Date createdate;

    private Byte isdelete;

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Byte getAction() {
        return action;
    }

    public void setAction(Byte action) {
        this.action = action;
    }

    public String getActiondesc() {
        return actiondesc;
    }

    public void setActiondesc(String actiondesc) {
        this.actiondesc = actiondesc == null ? null : actiondesc.trim();
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid == null ? null : dataid.trim();
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname == null ? null : dataname.trim();
    }

    public String getBeforeupdate() {
        return beforeupdate;
    }

    public void setBeforeupdate(String beforeupdate) {
        this.beforeupdate = beforeupdate == null ? null : beforeupdate.trim();
    }

    public String getAfterupdate() {
        return afterupdate;
    }

    public void setAfterupdate(String afterupdate) {
        this.afterupdate = afterupdate == null ? null : afterupdate.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }
}