package com.website.raovat.model;

public class UserModel {
	String name;
	String account;
	String password;
	String phanquyen;
	
	
	
	public UserModel(String name, String account, String password, String phanquyen) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.phanquyen = phanquyen;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhanquyen() {
		return phanquyen;
	}
	public void setPhanquyen(String phanquyen) {
		this.phanquyen = phanquyen;
	}
	
	
}
