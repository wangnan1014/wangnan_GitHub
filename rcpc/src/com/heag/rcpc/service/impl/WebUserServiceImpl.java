package com.heag.rcpc.service.impl;

import com.heag.rcpc.dao.IWebUserDao;
import com.heag.rcpc.model.WebUser;
import com.heag.rcpc.service.IWebUserService;

/**
 * Created by Administrator on 2015-6-16 0016.
 */
public class WebUserServiceImpl implements IWebUserService{

    private IWebUserDao webUserDao;

    public Integer insert(String username, String password, String truename) {

        WebUser user=new WebUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setTruename(truename);

        return webUserDao.insert(user);
    }

    public WebUser login(String username, String password) {
        return null;
    }

    public void setWebUserDao(IWebUserDao webUserDao) {
        this.webUserDao = webUserDao;
    }

}
