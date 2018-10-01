package com.website.raovat.model;

public class Product {
	int idProduct;
	String name;
	String image;
	String info;
	String title;
	Boolean status;
	String addr;
	int idUser;
	int price;
	int menuproduct;
	String tenUser;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String image, String info, String title, Boolean status, String addr, int idUser, int price, int menuproduct) {
		super();
		this.name = name;
		this.image = image;
		this.info = info;
		this.title = title;
		this.status = status;
		this.addr = addr;
		this.idUser = idUser;
		this.price = price;
		this.menuproduct = menuproduct;
	}
	
	public Product(int idProduct, String name, String image, String info, String title, Boolean status, String addr,
			int idUser, int price, int menuproduct, String tenUser) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.image = image;
		this.info = info;
		this.title = title;
		this.status = status;
		this.addr = addr;
		this.idUser = idUser;
		this.price = price;
		this.menuproduct = menuproduct;
		this.tenUser = tenUser;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMenuproduct() {
		return menuproduct;
	}
	public void setMenuproduct(int menuproduct) {
		this.menuproduct = menuproduct;
	}
	public String getTenUser() {
		return tenUser;
	}
	public void setTenUser(String tenUser) {
		this.tenUser = tenUser;
	}
	
	
}
