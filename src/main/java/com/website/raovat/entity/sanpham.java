package com.website.raovat.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity(name="sanpham")
public class sanpham implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idSanPham;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idDMSP")
	danhmucsanpham DMSP;
	String tenSanPham;
	String imageSanPham;
	String moTa;
	String tieuDe;
	Boolean trangThai;
	String diaChi;
	int gia;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUser")
	user nguoiDung;
	
	public sanpham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public sanpham(int idSanPham, danhmucsanpham dMSP, String tenSanPham, String imageSanPham, String moTa,
			String tieuDe, Boolean trangThai, String diaChi, int gia, user nguoiDung) {
		super();
		this.idSanPham = idSanPham;
		DMSP = dMSP;
		this.tenSanPham = tenSanPham;
		this.imageSanPham = imageSanPham;
		this.moTa = moTa;
		this.tieuDe = tieuDe;
		this.trangThai = trangThai;
		this.diaChi = diaChi;
		this.gia = gia;
		this.nguoiDung = nguoiDung;
	}
	
	public sanpham(danhmucsanpham dMSP, String tenSanPham, String imageSanPham, String moTa, String tieuDe,
			Boolean trangThai, String diaChi, int gia, user nguoiDung) {
		super();
		DMSP = dMSP;
		this.tenSanPham = tenSanPham;
		this.imageSanPham = imageSanPham;
		this.moTa = moTa;
		this.tieuDe = tieuDe;
		this.trangThai = trangThai;
		this.diaChi = diaChi;
		this.gia = gia;
		this.nguoiDung = nguoiDung;
	}
	
	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}

	public danhmucsanpham getDMSP() {
		return DMSP;
	}

	public void setDMSP(danhmucsanpham dMSP) {
		DMSP = dMSP;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getImageSanPham() {
		return imageSanPham;
	}

	public void setImageSanPham(String imageSanPham) {
		this.imageSanPham = imageSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public user getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(user nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	
	
	
}
