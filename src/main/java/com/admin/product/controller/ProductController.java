package com.admin.product.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.admin.product.model.Product;
import com.admin.product.service.ProductService;

//import app10d.ProductForm;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "ProductForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@Valid Product product, Errors errors) throws SQLException {

		if (errors.hasErrors()) {
			return "ProductForm";
		}
		service.save(product);
		return "redirect:/product/" + product.getPid();

	}

	@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
	public String showProductDetail(@PathVariable String pid, Model model) throws SQLException {

		Product product = new Product();
		product.setPid(pid);
		Product result = service.searchByPid(product);
		model.addAttribute("product", result);
		return "ProductDetails";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearchProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "SearchProductForm";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchProduct(@Valid Product product, Errors errors, Model model) throws SQLException {

		if (errors.hasErrors()) {
			return "SearchProductForm";
		}
		List<Product> products = service.search(product);
		model.addAttribute("products", products);
		return "SearchProductDetails";

	}

	@RequestMapping(value = "/showall", method = RequestMethod.GET)
	public String showallProducts(Model model) throws SQLException {

		List<Product> products = service.showallProducts();
		model.addAttribute("products", products);
		return "ShowProductDetails";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteById(Product product, Model model) throws SQLException {
		service.deleteById(product);
		List<Product> products = service.showallProducts();
		model.addAttribute("products", products);
		return "ShowProductDetails";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String updateById(Product product, Model model) throws SQLException {
		Product result = service.searchById(product);
		model.addAttribute("product", result);
		return "ProductEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateById(@Valid Product product, Errors errors, Model model) throws SQLException {
		if (errors.hasErrors()) {
			return "ProductEdit";
		}
		service.updateById(product);
		return "redirect:/product/" + product.getPid();
	}

}
