package com.heag.rcpc.util;

import com.heag.rcpc.model.RpUser;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by Administrator on 2015-6-24 0024.
 */
public class AuthorityUtil extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        //TODO

        // 取得请求相关的ActionContext实例
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        String user = (String) session.get("username");
        RpUser u = (RpUser) session.get("user");

        if (u != null && user != null) {
        //    System.out.println("it's ok!");
            return invocation.invoke();
        }

      //  System.out.println("it's not ok!");
        //ctx.put("tip", "你还没有登录");
        return Action.LOGIN;

    }
}
