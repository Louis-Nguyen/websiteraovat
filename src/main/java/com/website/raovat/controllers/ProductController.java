package com.website.raovat.controllers;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.website.raovat.entity.danhmucsanpham;
import com.website.raovat.entity.sanpham;
import com.website.raovat.entity.user;
import com.website.raovat.model.Product;
import com.website.raovat.services.ProductServices;
import com.website.raovat.services.UserServices;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductServices productServices;
	//==================== Done =====================
	@GetMapping("/search")
	public @ResponseBody List<Product> GetAllProductSelling(){
		List<sanpham> list  =  new ArrayList<sanpham>();
		String  sql = "from sanpham where trangThai=1";
		list  =  productServices.getProduct(sql);
		List<Product> listProduct = new ArrayList<Product>() ;
		for(sanpham sp : list) {
			Product product = new Product(sp.getIdSanPham(), sp.getTenSanPham(), sp.getImageSanPham(), sp.getMoTa(), sp.getTieuDe(), sp.getTrangThai(), sp.getDiaChi(),
					sp.getNguoiDung().getIdUser(),sp.getGia(), sp.getDMSP().getIdDMSP(), sp.getNguoiDung().getHoTen());
			listProduct.add(product);
		}
		return listProduct;
	}
	//==================== Done =====================
	@GetMapping("/published/{iduser}")
	public  @ResponseBody List<Product> GetProductToAccountPublished(@PathVariable("iduser") int iduser){
		List<sanpham> list  =  new ArrayList<sanpham>();
		String  sql ="from sanpham where idUser=" + iduser +" AND trangThai=1";
		list  =  productServices.getProduct(sql);
		List<Product> listProduct = new ArrayList<Product>() ;
		for(sanpham sp : list) {
			Product product = new Product(sp.getIdSanPham(), sp.getTenSanPham(), sp.getImageSanPham(), sp.getMoTa(), sp.getTieuDe(), sp.getTrangThai(), sp.getDiaChi(),
					sp.getNguoiDung().getIdUser(),sp.getGia(), sp.getDMSP().getIdDMSP(), sp.getNguoiDung().getHoTen());
			listProduct.add(product);
		}
		return listProduct;
	}
	//==================== Done =====================
	@GetMapping("/selled/{iduser}")
	public @ResponseBody List<Product> GetProductToAccountSelled(@PathVariable("iduser") int iduser){
		List<sanpham> list  =  new ArrayList<sanpham>();
		String  sql = "from sanpham where idUser=" + iduser +" AND trangThai=0";
		list  =  productServices.getProduct(sql);
		List<Product> listProduct = new ArrayList<Product>() ;
		for(sanpham sp : list) {
			Product product = new Product(sp.getIdSanPham(), sp.getTenSanPham(), sp.getImageSanPham(), sp.getMoTa(), sp.getTieuDe(), sp.getTrangThai(), sp.getDiaChi(),
					sp.getNguoiDung().getIdUser(),sp.getGia(), sp.getDMSP().getIdDMSP(), sp.getNguoiDung().getHoTen());
			listProduct.add(product);
		}
		return listProduct;
	}
	//==================== Done =====================
	@PostMapping("/post")
	public @ResponseBody Product insert(@RequestBody Product newProduct) {
		try {
			danhmucsanpham dmsp = new danhmucsanpham();
			dmsp =	productServices.getDMSP("from danhmucsanpham where idDMSP="+ newProduct.getMenuproduct());
			user users = productServices.getUser("from user where idUser="+newProduct.getIdUser());
			sanpham NewSanPham = new sanpham(dmsp, newProduct.getName(), newProduct.getImage(), newProduct.getInfo(), newProduct.getTitle(),
					true,newProduct.getAddr(), newProduct.getPrice(), users);
			sanpham sp =  productServices.insert(NewSanPham);
			if(sp !=null) {
				Product product = new Product(sp.getIdSanPham(), sp.getTenSanPham(), sp.getImageSanPham(), sp.getMoTa(), sp.getTieuDe(), true, sp.getDiaChi(),
						sp.getNguoiDung().getIdUser(),sp.getGia(), sp.getDMSP().getIdDMSP(), sp.getNguoiDung().getHoTen());
				return product;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		

	}
	// ============== Done =================
	@PutMapping("/update")
	public @ResponseBody Product replaceProduct(@RequestBody Product ReplaceProduct) {
		sanpham ProductOld = productServices.findProduct(ReplaceProduct.getIdProduct());
		if(ProductOld != null) {
			sanpham ProductUpdate = new sanpham(ProductOld.getIdSanPham(), ProductOld.getDMSP(), ReplaceProduct.getName(), ReplaceProduct.getImage(), ReplaceProduct.getInfo(),
					ReplaceProduct.getTitle(),ReplaceProduct.getStatus(),ReplaceProduct.getAddr(), ReplaceProduct.getPrice(), ProductOld.getNguoiDung());
			sanpham sp = productServices.update(ProductUpdate);		
			Product productafterupdate = new Product(sp.getIdSanPham(), sp.getTenSanPham(), sp.getImageSanPham(),sp.getMoTa(), sp.getTieuDe(), sp.getTrangThai(), sp.getDiaChi(),
					sp.getNguoiDung().getIdUser(),sp.getGia(), sp.getDMSP().getIdDMSP(), sp.getNguoiDung().getHoTen()); 
			return productafterupdate;
		}
		else {
			 return null;
		}
	}
	//============ Error ==============
	@DeleteMapping("/{id}")
	public @ResponseBody boolean DeleteProduct(@PathVariable int id) {
		sanpham  Sanpham  = (sanpham) productServices.findProduct(id);
		System.out.println(Sanpham);
		if(Sanpham != null) {
			System.out.println("name: "+ Sanpham.getTenSanPham() +"-"+ Sanpham);
			return productServices.delete(Sanpham);
		}
		else {
			return false;
		}
	}
	
}
