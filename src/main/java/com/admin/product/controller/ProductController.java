package com.admin.product.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.admin.product.model.Product;
import com.admin.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
    public String showProductForm(){
        return "ProductForm";
    }
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
    public String addProduct(@Valid Product product, Errors errors) throws SQLException{  	

		service.save(product);
			
		return "ProductDetails";
    }
}
