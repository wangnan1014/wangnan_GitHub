package com.heag.rcpc.action;

import com.heag.rcpc.model.RpUser;
import com.heag.rcpc.service.IRpLogService;
import com.heag.rcpc.service.IRpUserService;
import com.heag.rcpc.util.ConstantsUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

import java.io.PrintWriter;

/**
 * Created by Administrator on 2015-6-16 0016.
 */
public class LoginAction extends ActionSupport {

    private static final Logger logger=Logger.getLogger("report.debug");

    private IRpUserService rpUserService;

    private IRpLogService rpLogService;

    private String username;

    private String password;

    private String remember;


    public String execute() throws Exception {
     //   Integer ret=webUserService.insert("11","22","33");
    //    logger.info("insert ret:"+ret);
    //    logger.info("hello!struts! username:"+username+" password:"+password+" remember:"+remember);
     //   rpLogService.insert(1,"admin",1,"",1,"", ConstantsUtil.LLOGIN,"testpage",null,null,null,null,null);
        return SUCCESS;
    }

    public void login(){
    	
        HttpSession session = ServletActionContext.getRequest().getSession();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=null;

        //JSONObject data = new JSONObject();

        int result = 0;


        logger.info("login is called!");
        logger.info("username:"+username+" password:"+password+" remember:"+remember);

        RpUser user=rpUserService.loginWithModelRet(username,password);
        if(null!=user){

            session.setAttribute("username",username);
            session.setAttribute("user",user);//TEST
            session.setAttribute("islogin",1);
            session.setAttribute("realname",user.getRealname());
            result=1;
            logger.info("longin success!");
            rpLogService.insert(user.getUid(),username,user.getCid(),user.getCname(),user.getDeptid(),user.getDeptname(),ConstantsUtil.LLOGIN,"/login.action",null,null,null,null,null);
        }

        try {
            out = response.getWriter();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out!=null){
                out.println(result);
                out.close();
            }
        }

        if(result==0) {
            logger.info("login failed!");
        }
    }

    public String mainpage(){

        logger.info("mainpage is called!");

        return "main";
    }

    public String logout(){

        logger.info("logout is called!");

        HttpSession session = ServletActionContext.getRequest().getSession();
        RpUser user=(RpUser)session.getAttribute("user");
        if(user!=null) {
            rpLogService.insert(user.getUid(), user.getUname(), user.getCid(), user.getCname(), user.getDeptid(), user.getDeptname(), ConstantsUtil.LLOGOUT, "/login!logout.action", null, null, null, null, null);
        }
        session.invalidate();//让session无效
    //    session.removeAttribute("username");
    //    session.removeAttribute("islogin");

        return "logout";
    }



    public void setRpLogService(IRpLogService rpLogService) {
        this.rpLogService = rpLogService;
    }


    public void setRpUserService(IRpUserService rpUserService) {
        this.rpUserService = rpUserService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

}
