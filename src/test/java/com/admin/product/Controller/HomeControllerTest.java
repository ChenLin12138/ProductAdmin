package com.admin.product.Controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.admin.product.controller.HomeController;

public class HomeControllerTest {

	@Test
	public void testHome() {
		HomeController controller = new HomeController();
		assertEquals("home",controller.home());
	}
	
}
