package com.website.raovat.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.website.raovat.entity.sanpham;
import com.website.raovat.entity.user;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ProductDao {
	@Autowired
	private SessionFactory sessionfactory;
	
	@Transactional
	public sanpham insert(sanpham product) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.save(product);
			return product;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public sanpham update(sanpham product) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.update(product);
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Transactional
	public sanpham delete(sanpham product) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.delete(product);
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	@Transactional
	public List<sanpham> findProductByAccountSelling(int idUser) {
		Session session = sessionfactory.getCurrentSession();
		try {
			List<sanpham> productList  = (List<sanpham>) session.createQuery("from sanpham where idUser='"+idUser+"' AND trangThai=1").getResultList();
			return productList;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Transactional
	public List<sanpham> findProductByAccountSold(int idUser) {
		Session session = sessionfactory.getCurrentSession();
		try {
			List<sanpham> productList  = (List<sanpham>) session.createQuery("from sanpham where idUser='"+idUser+"' AND trangThai=0").getResultList();
			return productList;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Transactional
	public List<sanpham> getProduct(String sql){
		Session session = sessionfactory.getCurrentSession();
		try {
			List<sanpham> productList  = (List<sanpham>) session.createQuery(sql).getResultList();
			return productList;
		} catch (Exception e) {
			return null;
		}		
	}	
}
