package com.admin.product.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest {
	
	@Test
	public void setNameandGet() {
		Product product = new Product();
		product.setName("lanlan");
		assertEquals("lanlan",product.getName());
	}
}