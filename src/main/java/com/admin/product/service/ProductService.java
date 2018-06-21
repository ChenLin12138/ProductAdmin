package com.admin.product.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.product.model.Product;
import com.admin.product.repo.ProductRepo;


@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	public void save(Product product) throws SQLException {

			productRepo.insert(product);
	}
	
	public List<Product> search(Product product) throws SQLException {

			return productRepo.getProductsByName(product);

	
	}	public List<Product> showallProducts() throws SQLException {

	return productRepo.getProducts();


	}
	
	public Product searchById(Product product) throws SQLException {
		
		Product result = productRepo.getProductsById(product);
		return result;
	}

//	public List<Product> search(Product product) {
//
//		ProductDAO productDAO = DAOFactory.getProductDAO();
//		List<Product> products = null;
//		try {
//			products = productDAO.getProductsByName(product);
//
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//		return products;
//	}
//
//	public List<Product> showall() {
//
//		ProductDAO productDAO = DAOFactory.getProductDAO();
//		List<Product> products = null;
//		try {
//			products = productDAO.getProducts();
//
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//		return products;
//	}
//
//	public void delete(Product product) {
//
//		ProductDAO productDAO = DAOFactory.getProductDAO();
//		// List<Product> products=null;
//		try {
//			productDAO.deleteProductsById(product);
//
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//		// return products;
//	}
//

//
//	public void savebyid(Product product) {
//
//		ProductDAO productDAO = DAOFactory.getProductDAO();
//
//		try {
//			productDAO.saveProductsById(product);
//
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//
//	}

}
