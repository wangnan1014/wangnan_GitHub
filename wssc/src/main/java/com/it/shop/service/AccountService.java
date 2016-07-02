package com.it.shop.service;

import com.it.shop.user.Account;

public interface AccountService extends BaseService<Account> {//注意BaseService里的泛型现在是Account  
	 /* 
     * 只要添加AccountService本身需要的新的方法即可，公共方法已经在BaseService中了 
     */  

}
