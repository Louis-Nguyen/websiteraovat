package com.website.raovat.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.raovat.dao.ProductDao;
import com.website.raovat.entity.sanpham;

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
	public sanpham delete(sanpham product) {
		return productDao.delete(product);
	}
	@Transactional
	public List<sanpham> findProductByAccountSelling(int idUser) {
		return productDao.findProductByAccountSelling(idUser);
	}
	@Transactional
	public List<sanpham> findProductByAccountSold(int idUser) {
		return productDao.findProductByAccountSold(idUser);
	}
	@Transactional
	public List<sanpham> getProduct(String sql){
		return productDao.getProduct(sql);
	}	
}
