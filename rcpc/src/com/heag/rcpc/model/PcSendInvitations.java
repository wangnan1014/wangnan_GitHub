package com.heag.rcpc.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class PcSendInvitations {
	/**
	     * This field was generated by MyBatis Generator.
	     * This field corresponds to the database column pc_askinfo.aid
	     *
	     * @mbggenerated
	     */
	    @Autowired
		private Integer id;
	    private Integer eid;
	    private String relation;
	    private String evaluator;
	    private String evaluation;
	    private String email;
	    private String emailstatues;
	    private String emailsendtime;
	    private String completestatus;
	    private String completetime;
	    private String isdelete;
	    private String remark;
	    private String createdate;
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getId() {
			return id;
		}
		public void setEid(Integer eid) {
			this.eid = eid;
		}
		public Integer getEid() {
			return eid;
		}
		public void setRelation(String relation) {
			this.relation = relation;
		}
		public String getRelation() {
			return relation;
		}
		public void setEvaluation(String evaluation) {
			this.evaluation = evaluation;
		}
		public String getEvaluation() {
			return evaluation;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEmail() {
			return email;
		}
		public void setEmailstatues(String emailstatues) {
			this.emailstatues = emailstatues;
		}
		public String getEmailstatues() {
			return emailstatues;
		}
		public void setEmailsendtime(String emailsendtime) {
			this.emailsendtime = emailsendtime;
		}
		public String getEmailsendtime() {
			return emailsendtime;
		}
		public void setCompletestatus(String completestatus) {
			this.completestatus = completestatus;
		}
		public String getCompletestatus() {
			return completestatus;
		}
		public void setCompletetime(String completetime) {
			this.completetime = completetime;
		}
		public String getCompletetime() {
			return completetime;
		}
		public void setIsdelete(String isdelete) {
			this.isdelete = isdelete;
		}
		public String getIsdelete() {
			return isdelete;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getRemark() {
			return remark;
		}
		public void setCreatedate(String createdate) {
			this.createdate = createdate;
		}
		public String getCreatedate() {
			return createdate;
		}
		public void setEvaluator(String evaluator) {
			this.evaluator = evaluator;
		}
		public String getEvaluator() {
			return evaluator;
		}

}
