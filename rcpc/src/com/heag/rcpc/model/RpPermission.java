package com.heag.rcpc.model;

import java.util.Date;

public class RpPermission {
    private Integer pid;

    private String pname;

    private String accesspage;

    private String pdesc;

    private String specialdesc;

    private Byte ptype;

    private Date createdate;

    private Byte isdelete;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getAccesspage() {
        return accesspage;
    }

    public void setAccesspage(String accesspage) {
        this.accesspage = accesspage == null ? null : accesspage.trim();
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public String getSpecialdesc() {
        return specialdesc;
    }

    public void setSpecialdesc(String specialdesc) {
        this.specialdesc = specialdesc == null ? null : specialdesc.trim();
    }

    public Byte getPtype() {
        return ptype;
    }

    public void setPtype(Byte ptype) {
        this.ptype = ptype;
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