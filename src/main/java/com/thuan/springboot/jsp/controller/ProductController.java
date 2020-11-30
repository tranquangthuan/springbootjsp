package com.thuan.springboot.jsp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thuan.springboot.jsp.entity.Product;
import com.thuan.springboot.jsp.service.ProductServiceImpl;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAll(Model model) {

		List<Product> products = productServiceImpl.getProducts();
		model.addAttribute("products", products);

		return "products";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable long id) {
		System.out.println("id = " + id);

		Optional<Product> editProduct = productServiceImpl.findById(id);
		if (editProduct.isPresent()) {
			model.addAttribute("product", editProduct.get());
			return "EditProduct";
		}
		model.addAttribute("message", "Product not exist");
		List<Product> products = productServiceImpl.getProducts();
		model.addAttribute("products", products);

		return "products";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String update(@ModelAttribute("product") Product product) {

		productServiceImpl.save(product);
		return "redirect:/product/all";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(Model model) {
		model.addAttribute("product", new Product());
		return "NewProduct";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable long id) {
		System.out.println("id = " + id);
		productServiceImpl.deleteById(id);

		return "redirect:/product/all";
	}
}
