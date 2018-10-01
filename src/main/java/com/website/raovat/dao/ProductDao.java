package com.website.raovat.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.website.raovat.entity.danhmucsanpham;
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
	public boolean delete(sanpham sp) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.delete(sp);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
	}
	@Transactional
	public sanpham findProduct(int idProduct) {
		Session session = sessionfactory.getCurrentSession();
		try {
			String sql = "from sanpham where idSanPham="+idProduct;
			sanpham product = (sanpham) session.createQuery(sql).uniqueResult();
			return product;
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
	@Transactional
	public danhmucsanpham getDMSP(String sql){
		Session session = sessionfactory.getCurrentSession();
		try {
			danhmucsanpham DMSP = (danhmucsanpham) session.createQuery(sql).uniqueResult();
			return DMSP;
		} catch (Exception e) {
			return null;
		}		
	}
	@Transactional
	public user getUser(String sql){
		Session session = sessionfactory.getCurrentSession();
		try {
			user User = (user) session.createQuery(sql).uniqueResult();
			return User;
		} catch (Exception e) {
			return null;
		}		
	}
}
