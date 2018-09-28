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
import org.springframework.web.bind.annotation.RestController;

import com.website.raovat.entity.sanpham;
import com.website.raovat.entity.user;
import com.website.raovat.model.User;
import com.website.raovat.services.UserServices;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserServices userService;
	
	@GetMapping("/getall")
	public List<User> GetAllUsers() {
		List<user> list = new ArrayList<user>();
		list  = userService.getAll();
		List<User> listUser  = new ArrayList<User>();
		for(user Users : list) {
			List<Integer> listIdsp = new ArrayList<Integer>();
			Set<sanpham> listSp = Users.getSanPham() ;
			for(sanpham sp: listSp) {
				listIdsp.add(sp.getIdSanPham());
				// ========== test =============
				System.out.println(sp.getIdSanPham());
			}
			User UserElement = new User(Users.getIdUser(),Users.getPhanQuyen(),Users.getHoTen(),Users.getDiaChi(),Users.getGioiTinh(),Users.getSoDT(),Users.getImage(),Users.getAge(),Users.getAccount(),Users.getPassword(),Users.getCash(),listIdsp);
			listUser.add(UserElement);
		}
		for(User test: listUser) {
			System.out.println(test.getEmail());
		}
		return listUser;
	}
	//===========Done==============
	@PostMapping("/login")
	public User Login(@RequestBody User userLogin) {
		user users = userService.KiemTraDangNhap(userLogin.getEmail(), userLogin.getPass());
		if(users != null) {
			List<Integer> listIdSp = new ArrayList<Integer>();
			try {
				Set<sanpham> set = users.getSanPham();
				for(sanpham sp : set) {
					listIdSp.add(sp.getIdSanPham());
				}
				User Users = new User(users.getIdUser(), users.getPhanQuyen(), users.getHoTen(), users.getDiaChi(),users.getGioiTinh(), users.getSoDT(), users.getImage(),
						users.getAge(),users.getAccount(), users.getPassword(), users.getCash(), listIdSp);
				return Users;
			} catch (Exception e) {
				System.out.println("Error !");
				return null;
			}
		
		}
		else {
			return null;
		}
	}
	// ============ Done =====================
	@PostMapping("/register")
	public user insert(@RequestBody User userRegister) {
		user User = userService.findByAccount(userRegister.getEmail());
		System.out.println("=========="+userRegister.getEmail()+"===========");
		if(User == null) {
			userRegister.setPhanQuyen("user");
			userRegister.setCash(0);
			user UserRegis = new user(userRegister.getPhanQuyen(),userRegister.getName(),userRegister.getAddr(),userRegister.getSex(),userRegister.getNumber(),userRegister.getAvata(),userRegister.getOld(),userRegister.getEmail(),userRegister.getPass(),userRegister.getCash(),null);
			userService.insert(UserRegis);
			return UserRegis;
		}
		else {
			return null;
		}
	}

	@GetMapping("/{email}")
	public User findByAccount(@PathVariable("email") String email) {
		user user_single = userService.findByAccount(email);
		User User_single = new User(user_single.getIdUser(), user_single.getPhanQuyen(), user_single.getHoTen(), user_single.getDiaChi(),user_single.getGioiTinh(), user_single.getSoDT(), user_single.getImage(),
				user_single.getAge(),user_single.getAccount(), user_single.getPassword(), user_single.getCash(), null);
		return User_single;
	}

	@PutMapping("/update")
	public User replaceUser(@RequestBody User ReplaceUser) {
		user user_single = userService.findByAccount(ReplaceUser.getEmail());
		if(user_single != null) {
			user UserRep = new user(ReplaceUser.getName(),ReplaceUser.getAddr(),ReplaceUser.getSex(),ReplaceUser.getNumber(),ReplaceUser.getAvata(),ReplaceUser.getOld(),ReplaceUser.getPass(),ReplaceUser.getCash());
			userService.update(UserRep);
			return ReplaceUser;
		}
		else {
			return null;
		}
	}

	@DeleteMapping("/{email}")
	public boolean deleteUser(@PathVariable String email) {
		user user_single = userService.findByAccount(email);
		if(user_single != null) {
			return true;
		}
		else {
			return false;
		}
	
	}
}
