package com.website.raovat.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.website.raovat.dao.UserDAO;
import com.website.raovat.entity.user;

@Service
public class UserServices {
	@Autowired
	private UserDAO userDao;
	
	
	
	public user KiemTraDangNhap(String account, String password) {
		return userDao.KiemTraDangNhap(account, password);
	}


	
	@Transactional
	public user insert(user User) {
		 return userDao.insert(User);
	}

	@Transactional
	public user update(user User) {	
		 return userDao.update(User);
	}



	@Transactional
	public user delete(user User) {
		return userDao.delete(User);
		
	}


	@Transactional
	public user findByAccount(String account) {
		return userDao.findByAccount(account);
	}
	@Transactional
	public List<user> getAll(){
		return userDao.getAll();
	}
}
