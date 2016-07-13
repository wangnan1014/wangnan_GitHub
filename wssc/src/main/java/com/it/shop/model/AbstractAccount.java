package com.it.shop.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractAccount entity provides the base persistence definition of the
 * Account entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private String login;
	private String name;
	private String pass;
	protected Set<Category> categories;

	// Constructors

	/** default constructor */
	public AbstractAccount() {
	}

	/** full constructor */
	public AbstractAccount(String login, String name, String pass,
			Set categories) {
		this.login = login;
		this.name = name;
		this.pass = pass;
		this.categories = categories;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Set getCategories() {
		return this.categories;
	}

	public void setCategories(Set categories) {
		this.categories = categories;
	}

}