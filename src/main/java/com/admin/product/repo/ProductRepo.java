package com.admin.product.repo;

import java.sql.SQLException;
import java.util.List;
//import app10a.Product;

import com.admin.product.model.Product;

public interface ProductRepo{
	
		List<Product> getProducts() throws SQLException ;
		
		List<Product> getProductsByName(Product product) throws SQLException;
		
		void insert(Product product) throws SQLException;
		
		void deleteProductsById(Product product) throws SQLException;
		
		Product getProductsById(Product product) throws SQLException;
		
		Product getProductsByPid(Product product) throws SQLException;

		void deleteById(Product product)throws SQLException;

		void updateById(Product product)throws SQLException;
		
}
