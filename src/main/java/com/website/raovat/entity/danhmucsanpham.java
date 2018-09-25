package com.website.raovat.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity(name="danhmucsanpham")
public class danhmucsanpham implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idDMSP;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idDMSP")
	Set<sanpham> SanPham;
	String tenDM;
	String imageDM;
	public int getIdDMSP() {
		return idDMSP;
	}
	public void setIdDMSP(int idDMSP) {
		this.idDMSP = idDMSP;
	}
	public Set<sanpham> getSanPham() {
		return SanPham;
	}
	public void setSanPham(Set<sanpham> sanPham) {
		SanPham = sanPham;
	}
	public String getTenDM() {
		return tenDM;
	}
	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}
	public String getImageDM() {
		return imageDM;
	}
	public void setImageDM(String imageDM) {
		this.imageDM = imageDM;
	}
	
}
