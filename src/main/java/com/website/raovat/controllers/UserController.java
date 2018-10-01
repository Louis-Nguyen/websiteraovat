package com.website.raovat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.website.raovat.entity.sanpham;
import com.website.raovat.entity.user;
import com.website.raovat.model.User;
import com.website.raovat.services.UserServices;


/*@CrossOrigin(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServices userService;
	// ================ Done ==============
	@GetMapping("/getall")
	public @ResponseBody List<User> GetAllUsers() {
		List<user> listusers = new ArrayList<user>();
		listusers  = userService.getAll();
		List<User> listUsers = new ArrayList<User>();
		for(user users : listusers) {
			User Users = new User(users.getIdUser(), users.getPhanQuyen(), users.getHoTen(), users.getDiaChi(), users.getGioiTinh(), users.getSoDT(), users.getImage(),
					users.getAge(), users.getAccount(), users.getPassword(), users.getCash());
			listUsers.add(Users);
		}
		return listUsers;
	}
	// ================ Done ==============
	@PostMapping("/login")
	public @ResponseBody User Login(@RequestBody User userLogin) {
		user users = userService.KiemTraDangNhap(userLogin.getEmail(), userLogin.getPass());
		if(users != null) {
			User Users = new User(users.getIdUser(), users.getPhanQuyen(), users.getHoTen(), users.getDiaChi(), users.getGioiTinh(), users.getSoDT(), users.getImage(),
					users.getAge(), users.getAccount(), users.getPassword(), users.getCash()); 
			return Users;
		}
		else {
			return null;
		}
	}
	// =============== Done =====================
	@PostMapping("/register")
	public @ResponseBody User insert(@RequestBody User userRegister) {
		user user = userService.findByAccount(userRegister.getEmail());
		if(user == null) {
			userRegister.setPhanQuyen("user");
			userRegister.setCash(0);
			user UserRegis = new user(userRegister.getPhanQuyen(),userRegister.getName(),userRegister.getAddr(),userRegister.getSex(),userRegister.getNumber(),userRegister.getAvata(),userRegister.getOld(),userRegister.getEmail(),userRegister.getPass(),userRegister.getCash(),null);
			userService.insert(UserRegis);
			user users = userService.findByAccount(userRegister.getEmail());
			User Users = new User(users.getIdUser(), users.getPhanQuyen(), users.getHoTen(), users.getDiaChi(), users.getGioiTinh(), users.getSoDT(), users.getImage(),
					users.getAge(), users.getAccount(), users.getPassword(), users.getCash());
			return Users;
		}
		else {
			return null;
		}
	}
	// ================ Done ==============
	@GetMapping("/{email}")
	public @ResponseBody User findByToAccount(@PathVariable("email") String email) {
		String Email = email +".com";
		System.out.println("email:" + Email);
		user users = userService.findByAccount(Email);
		if(users != null) {
			User Users = new User(users.getIdUser(), users.getPhanQuyen(), users.getHoTen(), users.getDiaChi(), users.getGioiTinh(), users.getSoDT(), users.getImage(),
					users.getAge(), users.getAccount(), users.getPassword(), users.getCash());
			return Users;
		}
		else {
			return null;
		}
	}
	//============== Error ===================
	@PutMapping("/update")
	public @ResponseBody User replaceUser(@RequestBody User ReplaceUser) {
		user user_single = userService.findByAccount(ReplaceUser.getEmail());
		if(user_single != null) {
			user UserRep = new user(user_single.getIdUser(), user_single.getPhanQuyen(), ReplaceUser.getName(), ReplaceUser.getAddr(), ReplaceUser.getSex(), ReplaceUser.getNumber(), ReplaceUser.getAvata(),
					ReplaceUser.getOld(), ReplaceUser.getEmail(), ReplaceUser.getPass(), ReplaceUser.getCash(),user_single.getSanPham());
			user users = userService.update(UserRep);
			User Usersafterupdate = new User(users.getIdUser(), users.getPhanQuyen(), users.getHoTen(), users.getDiaChi(), users.getGioiTinh(), users.getSoDT(), users.getImage(),
					users.getAge(), users.getAccount(), users.getPassword(), users.getCash());
			System.out.println("Update Success User!");
			return Usersafterupdate;
		}
		else {
			System.out.println("Update Fail User!");
			return null;
		}
	}
	//============ Error ==============
	@DeleteMapping("/{email}")
	public @ResponseBody boolean deleteUser(@PathVariable String email) {
		user user_single = userService.findByAccount(email);
		if(user_single != null) {
			userService.delete(user_single);
			System.out.println("Delete Success User!");
			return true;
		}
		else {
			System.out.println("Delete Fail User!");
			return false;
		}
	
	}
}
