package com.admin.product.Controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.admin.product.controller.ProductController;

public class ProductControllerTest {
	
	@Test
	public void showProductForm() {
		ProductController controller = new ProductController();
		assertEquals("ProductForm",controller.showProductForm());
	}
}
