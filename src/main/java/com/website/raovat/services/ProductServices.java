package com.website.raovat.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.raovat.dao.ProductDao;
import com.website.raovat.entity.danhmucsanpham;
import com.website.raovat.entity.sanpham;
import com.website.raovat.entity.user;

@Service
public class ProductServices {
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public sanpham insert(sanpham product) {
		return productDao.insert(product);
	}

	@Transactional
	public sanpham update(sanpham product) {
		return productDao.update(product);
	}
	@Transactional
	public boolean delete(sanpham sp) {
		return productDao.delete(sp);
	}
	@Transactional
	public sanpham findProduct(int idProduct) {
		return productDao.findProduct(idProduct);
	}
	@Transactional
	public List<sanpham> getProduct(String sql){
		return productDao.getProduct(sql);
	}	
	@Transactional
	public danhmucsanpham getDMSP(String sql){
		return productDao.getDMSP(sql);
	}	
	@Transactional
	public user getUser(String sql){
		return productDao.getUser(sql);
	}	
}
