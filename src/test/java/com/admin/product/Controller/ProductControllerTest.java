package com.admin.product.Controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;

import com.admin.product.controller.ProductController;
import com.admin.product.model.Product;

public class ProductControllerTest {

	
	@Test
	public void showProductForm() {
		Model model = new BindingAwareConcurrentModel();
		ProductController controller = new ProductController();
		assertEquals("ProductForm",controller.showProductForm(model));
	}
}
