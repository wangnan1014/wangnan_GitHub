package com.heag.rcpc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.heag.rcpc.model.RpCompany;
import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpIndustry;
import com.heag.rcpc.model.RpProvince;
import com.heag.rcpc.model.RpRegion;
import com.heag.rcpc.model.RpRole;
import com.heag.rcpc.service.IRpCompanyService;
import com.heag.rcpc.service.IRpDepartmentService;
import com.heag.rcpc.service.IRpIndustryService;
import com.heag.rcpc.service.IRpLogService;
import com.heag.rcpc.service.IRpProvinceService;
import com.heag.rcpc.service.IRpRegionService;
import com.heag.rcpc.service.IRpRoleService;
import com.heag.rcpc.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 给页面调用用
 * 
 * */
public class ToOutAction extends ActionSupport {
	private HttpServletRequest req = ServletActionContext.getRequest();
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private HttpServletResponse res = ServletActionContext.getResponse();
	private static final Logger logger = Logger.getLogger("report.debug");
	private String gotoPage;
	PrintWriter out;
	@Autowired
	private IRpLogService rpLogService;
	@Autowired
	private IRpCompanyService rpCompanyService;
	@Autowired
	private IRpDepartmentService rpDepartmentService;
	@Autowired
	private IRpProvinceService rpProvinceService;
	@Autowired
	private IRpRegionService rpRegionService;
	@Autowired
	private IRpIndustryService rpIndustryService;
	@Autowired
	private IRpRoleService RpRoleService;

	public String execute() throws Exception {

		return null;
	}

	/*
	 * 跳转页面 通过该方式让前台给div赋值
	 */
	public String gotoPage() throws Exception {
		logger.info("go to " + gotoPage);
		// req = ServletActionContext.getRequest();
		return SUCCESS;
	}

	public String getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(String gotoPage) {
		this.gotoPage = gotoPage;
	}

	public String getUserRoleList() throws IOException {
		res.setCharacterEncoding("UTF-8");
		ArrayList<RpRole> arr = RpRoleService.select();
		out = res.getWriter();
		out.print(JsonUtil.arrToJson(arr));

		out.close();
		return NONE;
	}

	public String getCompanyList() throws IOException {
		res.setCharacterEncoding("UTF-8");
		ArrayList<RpCompany> arr = rpCompanyService.selectByExample(null);
		out = res.getWriter();
		out.print(JsonUtil.arrToJson(arr));

		out.close();
		return NONE;
	}

	public String getDepartmentList() throws IOException {
		res.setCharacterEncoding("UTF-8");
		ArrayList<RpDepartment> arr = rpDepartmentService.selectByExample(null);
		out = res.getWriter();
		out.print(JsonUtil.arrToJson(arr));

		out.close();
		return NONE;
	}

	public String getProvinceList() throws IOException {
		res.setCharacterEncoding("UTF-8");
		ArrayList<RpProvince> arr = rpProvinceService.selectByExample(null);
		out = res.getWriter();
		out.print(JsonUtil.arrToJson(arr));

		out.close();
		return NONE;
	}

	public String getRegionList() throws IOException {
		res.setCharacterEncoding("UTF-8");
		ArrayList<RpRegion> arr = rpRegionService.selectByExample(null);
		out = res.getWriter();
		out.print(JsonUtil.arrToJson(arr));

		out.close();
		return NONE;
	}

	public String getIndustryList() throws IOException {
		res.setCharacterEncoding("UTF-8");
		ArrayList<RpIndustry> arr = rpIndustryService.selectByExample(null);
		out = res.getWriter();
		out.print(JsonUtil.arrToJson(arr));

		out.close();
		return NONE;
	}
}
