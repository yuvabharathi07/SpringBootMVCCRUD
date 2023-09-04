package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.ProductRepository;
import com.example.model.Product;
@RestController
public class HomeController {
	private ProductRepository repository;
	
	public HomeController(ProductRepository repository) {
		System.out.println("Home Controller Invoked");
		this.repository = repository;
	}
	@RequestMapping("/")
	public String addProduct() {
		return "registration";
	}
	@PostMapping(path = "/saveProduct",consumes = "application/json")
	public String saveProduct(@RequestBody Product p) {
		repository.save(p);
		return "registration";
	}
	@PutMapping(path = "/updateProduct",consumes = "application/json")
	public Product updateProduct(@RequestBody Product p) {
		repository.save(p);
		System.out.println("Updated");
		return p;
	}
	@DeleteMapping(path = "/deleteProduct/{productid}")
	public String deleteProduct(@PathVariable("productid") int pid) {
		repository.deleteById(pid);
		return "Deleted";
	}
	
	@GetMapping(path = "/viewProducts",produces = {"application/json"})
	@ResponseBody
	public  Iterable<Product> allProducts(){
		return repository.findAll();
		
	}
	@GetMapping(path = "/product/{productid}",produces = "application/xml")
	@ResponseBody
	public Product  oneProduct(@PathVariable("productid") int pid){
		return repository.findById(pid).orElse(null);
		
	}
	
	@RequestMapping("/editProduct/{productid}")
	public String editProduct(@PathVariable("productid") int pid,Model m) {
		m.addAttribute("product", repository.findById(pid));
		return "productedit";
	}
	
	/*
	 * @RequestMapping("/updateProduct") public String
	 * updateProduct(@ModelAttribute("product") Product product) {
	 * service.updateProduct(product); return "productedit"; }
	 * 
	 * @RequestMapping("/deleteproduct/{productid}") public String
	 * deleteProduct(@PathVariable("productid") int pid,Model m) {
	 * service.deleteProduct(pid); List<Product> allproduct =
	 * service.viewProducts(); return "redirect:/viewProducts"; }
	 */
}
