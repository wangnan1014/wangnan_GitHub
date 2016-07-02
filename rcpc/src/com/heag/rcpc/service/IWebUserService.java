package com.heag.rcpc.service;

import com.heag.rcpc.model.WebUser;

/**
 * Created by Administrator on 2015-6-16 0016.
 */
public interface IWebUserService {

    public Integer insert(String username,String password,String truename);

    public WebUser login(String username,String password);
}
