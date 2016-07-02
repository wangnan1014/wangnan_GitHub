package com.heag.rcpc.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.heag.rcpc.dao.IRpLogDao;
import com.heag.rcpc.model.RpCompany;
import com.heag.rcpc.model.RpDepartment;
import com.heag.rcpc.model.RpLog;
import com.heag.rcpc.model.RpRole;
import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.service.IRpCompanyService;
import com.heag.rcpc.service.IRpDepartmentService;
import com.heag.rcpc.service.IRpLogService;
import com.heag.rcpc.service.IRpRoleService;
import com.heag.rcpc.service.IRpUserService;
import com.heag.rcpc.service.RegisterService;
import com.heag.rcpc.service.impl.RegisterServiceImpl;
import com.heag.rcpc.util.ApplicationUtil;
import com.heag.rcpc.util.ConstantsUtil;
import com.heag.rcpc.util.EncryptUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Created by Administrator on 2015-6-23 0016.
 * @author wn
 * 注册操作
 */
public class RegisterAction extends ActionSupport {
	
    private static final Logger logger=Logger.getLogger("report.debug");
    private String uname;
    private String password;
    private String o_password;
    private int result = -1;
    private HttpServletRequest req = ServletActionContext.getRequest();   
    
    private HttpSession session = ServletActionContext.getRequest().getSession();  
     
    private HttpServletResponse res = ServletActionContext.getResponse() ;
    
    private RpUser rpuser ;
      
    private IRpUserService rpUserService; 
    private IRpLogService rpLogService;
    public IRpCompanyService getRpCompanyService() {
		return rpCompanyService;
	}
	public void setRpCompanyService(IRpCompanyService rpCompanyService) {
		this.rpCompanyService = rpCompanyService;
	}
	public IRpDepartmentService getRpDepartmentService() {
		return rpDepartmentService;
	}
	public void setRpDepartmentService(IRpDepartmentService rpDepartmentService) {
		this.rpDepartmentService = rpDepartmentService;
	}
	private IRpRoleService rpRoleService;
    private IRpCompanyService rpCompanyService;
    private IRpDepartmentService rpDepartmentService;    
	/**
	 * 用户注册
     * @return 0:error;1:success,2:用户不存在,3:用户已存在
     * 
     * */
	public String execute() throws Exception {
		res.setCharacterEncoding("UTF-8");  

		PrintWriter out = res.getWriter();
		RpUser rpu = rpUserService.select(rpuser.getUname());
		if(rpu==null){
			result = rpUserService.insertByRpUser(rpuser);
    	if(result == 0){
    		logger.info("====user："+ rpuser.getUname() + " Register Error !!!!");
    	}else if(result == 1){
    		RpUser user = (RpUser) session.getAttribute("user");
			rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LINSERT, req.getRequestURI(), "rp_user",rpuser.getUid().toString(), null, null, null);
    	}}else{
    		logger.info("====user："+ rpuser.getUname() + " is find  !!!!");
    		result = 3;   			
    	}
		out.print(result);
    	out.close();
        return NONE;
    }
    /**
     * 密码修改
     * @return 0:原始密码不正确!,1:修改成功,2:用户不存在,3:用户已存在
     * */
    public String pwMod()  throws Exception{
    	//RegisterService rs = (RegisterService) ApplicationUtil.getBean("registerService");
    	RpUser rpu = rpUserService.select(rpuser.getUname());
    	HttpServletResponse res = ServletActionContext.getResponse();
    	res.setCharacterEncoding("UTF-8");
    	PrintWriter out = res.getWriter();
    	if(rpu!=null){
    		
    		if(rpu.getPassword().equals(EncryptUtil.encrypt(o_password ,ConstantsUtil.ENCRYPTDATE))){
	    		result = rpUserService.update(rpu.getUid(),rpuser.getPassword());
	       		logger.info("====user："+ rpuser.getUname() + " MOD SUCCESS !!!!");
	       		RpUser user = (RpUser) session.getAttribute("user");
    			rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LMODIFY, req.getRequestURI(), "rp_user",rpu.getUid().toString(), null, null, null);	
	    		result = 1;
	    	}else{
	    		logger.info("====user："+ rpuser.getUname() + " MOD Error !!!!");
	    		result = 0;
	    	}
    	}else{
    		logger.info("====user："+ rpuser.getUname() + " is unfind !!!!");
    		result = 2;
    	}
    	out.print(result); 
    	//out.flush();   
    	out.close();
    	//res.getWriter().write(result);
        return NONE;
    }
    /**
     * 
     * */
    public String select() {
    	//logger.info("==start=look=getRpRole、RpDepartment、RpCompany");
    	//ArrayList<RpRole> al_role  = selectRpRole();
    	//ArrayList<RpDepartment> al_dept  = selectRpDepartment();
    	//ArrayList<RpCompany> al_comp  = selectRpCompany();    	
    	//req.setAttribute("al_role", al_role);
    	//req.setAttribute("al_dept", al_dept);
    	//req.setAttribute("al_comp", al_comp);
    	return SUCCESS;
    }
    /**
     * 用户   权限 获取
     * 
     * */
    public ArrayList<RpRole> selectRpRole() {
		return rpRoleService.select();
	}
    /**
     * 用户部门  权限 获取
     * */    
    public ArrayList<RpDepartment> selectRpDepartment() {
		return rpDepartmentService.select();
	}
    /**
     * 用户   权限 获取
     * 
     * */    
    public ArrayList<RpCompany> selectRpCompany() {
		return  rpCompanyService.select();
	}    
    
    public ArrayList<RpRole> getRoleList(){
		
    	return null;
    }
    public RpUser getRpuser() {
		return rpuser;
	}
	public void setRpuser(RpUser rpuser) {
		this.rpuser = rpuser;
	}        
    public String getO_password() {
		return o_password;
	}
	public void setO_password(String oPassword) {
		o_password = oPassword;
	}
	public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}    
    public IRpUserService getRpUserService() {
		return rpUserService;
	}
	public void setRpUserService(IRpUserService rpUserService) {
		this.rpUserService = rpUserService;
	}
	public void setRpLogService(IRpLogService rpLogService) {
		this.rpLogService = rpLogService;
	}
	public IRpRoleService getRpRoleService() {
		return rpRoleService;
	}
	public void setRpRoleService(IRpRoleService rpRoleService) {
		this.rpRoleService = rpRoleService;
	}	

}
