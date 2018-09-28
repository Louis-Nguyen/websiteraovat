package com.website.raovat.model;

import java.util.List;


public class User {
	int idUser;
	String phanQuyen;
	String name;
	String addr;
	Boolean sex;
	String number;
	String avata;
	String old;
	String email;
	String pass;
	int cash;
	List<Integer> SanPham;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(int idUser, String phanQuyen, String name, String addr, Boolean sex, String number, String avata,
			String old, String email, String pass, int cash, List<Integer> sanPham) {
		super();
		this.idUser = idUser;
		this.phanQuyen = phanQuyen;
		this.name = name;
		this.addr = addr;
		this.sex = sex;
		this.number = number;
		this.avata = avata;
		this.old = old;
		this.email = email;
		this.pass = pass;
		this.cash = cash;
		SanPham = sanPham;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAvata() {
		return avata;
	}
	public void setAvata(String avata) {
		this.avata = avata;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public List<Integer> getSanPham() {
		return SanPham;
	}
	public void setSanPham(List<Integer> sanPham) {
		SanPham = sanPham;
	}
	
	
	

}
