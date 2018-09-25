package com.website.raovat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.raovat.entity.sanpham;
import com.website.raovat.entity.user;
import com.website.raovat.model.UserModel;
import com.website.raovat.services.UserServices;



@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserServices userService;
	@GetMapping("getall")
	public List<user> GetUsers() {
		List<user> list = new ArrayList<user>();
		list  = userService.getAll();
		return list;
	}
	@PostMapping("login")
	public user Login(@RequestParam String email, @RequestParam String password) {
		return userService.KiemTraDangNhap(email, password);
	}
	@PostMapping("insert")
	public user insert(@ModelAttribute user User) {
		return userService.insert(User);
	}

	@GetMapping("{email}")
	public user findByAccount(@PathVariable("email") String email) {
		user User = userService.findByAccount(email);
		return User;
	}

	@PutMapping("{email}")
	public user replaceUser(@ModelAttribute user RepUser ,@PathVariable String email) {
		user User = userService.findByAccount(email);
		if(User != null) {
				User.setAge(RepUser.getAge());
				User.setCash(RepUser.getCash());
				User.setDiaChi(RepUser.getDiaChi());
				User.setGioiTinh(RepUser.getGioiTinh());
				User.setHoTen(RepUser.getHoTen());
				User.setImage(RepUser.getImage());
				User.setPassword(RepUser.getPassword());
				User.setSoDT(RepUser.getSoDT());
				return userService.update(User);		
		}
		else {
			return null;
		}
	}

	@DeleteMapping("/{email}")
	public user deleteUser(@PathVariable String email) {
		user User = userService.findByAccount(email);
		if(User != null) {
			return userService.delete(User);
		}
		else {
			return null;
		}
		
		
	}
}
