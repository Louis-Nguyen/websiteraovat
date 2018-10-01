package com.website.raovat.entity;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="user")
public class user implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idUser;
	String phanQuyen;
	String hoTen;
	String diaChi;
	Boolean gioiTinh;
	String soDT;
	String image;
	String age;
	String account;
	String password;
	int cash;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idUser")
	List<sanpham> SanPham;
	
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public user(int idUser, String phanQuyen, String hoTen, String diaChi, Boolean gioiTinh, String soDT, String image,
			String age, String account, String password, int cash) {
		super();
		this.idUser = idUser;
		this.phanQuyen = phanQuyen;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.image = image;
		this.age = age;
		this.account = account;
		this.password = password;
		this.cash = cash;
	}

	public user(String hoTen, String diaChi, Boolean gioiTinh, String soDT, String image,
			String age, String password, int cash) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.image = image;
		this.age = age;
		this.password = password;
		this.cash = cash;
	}

	public user(String phanQuyen, String hoTen, String diaChi, Boolean gioiTinh, String soDT, String image,
			String age, String account, String password, int cash, List<sanpham> sanPham) {
		super();
		this.phanQuyen = phanQuyen;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.image = image;
		this.age = age;
		this.account = account;
		this.password = password;
		this.cash = cash;
		SanPham = sanPham;
	}
	
	public user(int idUser, String phanQuyen, String hoTen, String diaChi, Boolean gioiTinh, String soDT, String image,
			String age, String account, String password, int cash, List<sanpham> sanPham) {
		super();
		this.idUser = idUser;
		this.phanQuyen = phanQuyen;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.image = image;
		this.age = age;
		this.account = account;
		this.password = password;
		this.cash = cash;
		SanPham = sanPham;
	}

	public List<sanpham> getSanPham() {
		return SanPham;
	}
	public void setSanPham(List<sanpham> sanPham) {
		SanPham = sanPham;
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
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
}
