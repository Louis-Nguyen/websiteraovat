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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.raovat.entity.sanpham;
import com.website.raovat.services.ProductServices;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	private ProductServices productServices;
	
	
	@GetMapping("getall")
	public List<sanpham> GetAllProduct(){
		List<sanpham> listProduct  =  new ArrayList<sanpham>();
		String  sql = "from sanpham";
		listProduct  =  productServices.getProduct(sql);
		return listProduct;
	}
	@GetMapping("getallwithselling")
	public List<sanpham> GetAllProductSelling(){
		List<sanpham> listProduct  =  new ArrayList<sanpham>();
		String  sql = "from sanpham where trangThai=1";
		listProduct  =  productServices.getProduct(sql);
		return listProduct;
	}
	@GetMapping("{id}")
	public List<sanpham> GetProductToAccount(@PathVariable("id") int id){
		List<sanpham> listProduct  =  new ArrayList<sanpham>();
		String  sql = "from sanpham where idUser=" + id;
		listProduct  =  productServices.getProduct(sql);
		return listProduct;
	}
	
	@PostMapping("insert")
	public sanpham insert(@ModelAttribute sanpham Sanpham) {
		return productServices.insert(Sanpham);
	}
	@PutMapping("{id}")
	public sanpham replaceProduct(@ModelAttribute sanpham Sanpham,@PathVariable("id") String id) {
		sanpham product = (sanpham) productServices.getProduct("from sanpham where idSanPham='"+id+"'");
		product.setDMSP(Sanpham.getDMSP());
		product.setGia(Sanpham.getGia());
		product.setImageSanPham(Sanpham.getImageSanPham());
		product.setMoTa(Sanpham.getMoTa());
		product.setTenSanPham(Sanpham.getTenSanPham());
		product.setTieuDe(Sanpham.getTieuDe());
		product.setTrangThai(Sanpham.getTrangThai());
		return productServices.update(product);
	}
	
	@DeleteMapping("{id}")
	public sanpham DeleteProduct(@PathVariable("id") String id) {
		sanpham  Sanpham  = (sanpham) productServices.getProduct("from sanpham where idSanPham='"+id+"'");
		return productServices.delete(Sanpham);
	}
	
}
