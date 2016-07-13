package com.it.shop.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */
public class Account extends AbstractAccount implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String login, String name, String pass, Set categories) {
		super(login, name, pass, categories);
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")  
	public Set<Category> getCategories() {  
	    return this.categories;  
	}
}
