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

import com.website.raovat.entity.user;


@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserDAO  {
	@Autowired
	private SessionFactory sessionfactory;
	
	
	
	@Transactional
	public user KiemTraDangNhap(String account, String password) {
		Session session = sessionfactory.getCurrentSession();
		
		try {
			user UserLogin = (user) session.createQuery("from user where account ='"+ account +"' AND password='"+password+"'").uniqueResult();
			if(UserLogin!=null) {
				return UserLogin;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		
	}


	
	@Transactional
	public user insert(user User) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.save(User);
			return User;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public user update(user User) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.update(User);
			return User;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}



	@Transactional
	public user delete(user User) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.delete(User);
			return User;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}


	@Transactional
	public user findByAccount(String account) {
		Session session = sessionfactory.getCurrentSession();
		try {
			user InfoUser  = (user) session.createQuery("from user where account='"+account+"'").uniqueResult();
			return InfoUser;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Transactional
	public List<user> getAll(){
		Session session = sessionfactory.getCurrentSession();
		try {
			List<user> listUser = new ArrayList<user>();
			listUser = session.createQuery("from user").getResultList();
			return listUser;
		} catch (Exception e) {
			return null;
		}
		
	}
}

