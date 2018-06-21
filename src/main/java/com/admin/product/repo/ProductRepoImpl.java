package com.admin.product.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.admin.product.model.Product;


@Repository
public class ProductRepoImpl implements ProductRepo {
	
	@Autowired
	private JdbcOperations jdbcOperations;
	
	
//	public ProductDAOImpl (JdbcOperations jdbcOperations) {
//		this.jdbcOperations = jdbcOperations;
//	}

//	private static final String GET_PRODUCTS_SQL = "SELECT name," + "description,price,id FROM products";
//
//	public List<Product> getProducts() throws DAOException {
//		List<Product> products = new ArrayList<Product>();
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(GET_PRODUCTS_SQL);
//			resultSet = pStatement.executeQuery();
//
//			while (resultSet.next()) {
//				Product product = new Product();
//				product.setName(resultSet.getString("name"));
//				product.setId(resultSet.getInt("id"));
//				product.setDescription(resultSet.getString("description"));
//				product.setPrice(resultSet.getFloat("price"));
//				products.add(product);
//			}
//		} catch (SQLException e) {
//			throw new DAOException("Error getting products." + e.getMessage());
//		} finally {
//			closeDBObjects(resultSet, pStatement, connection);
//		}
//		return products;
//	}

	private static final String INSERT_PRODUCT_SQL = "INSERT INTO products" + "(name,description,price)"
			+ "VALUES(?,?,?)";
	
	@Override
	public void insert(Product product) throws SQLException{
		
		jdbcOperations.update(INSERT_PRODUCT_SQL,
				product.getName(),
				product.getDescription(),
				product.getPrice()
				);
	}

	private static final String GET_PRODUCTS_SQL="SELECT name,"
			+ "description,price,id FROM products";
	@Override
	public List<Product> getProducts() {
		List<Map<String, Object>> resultList = jdbcOperations.queryForList(GET_PRODUCTS_SQL);	
		List<Product> products = new ArrayList<Product>();
		for(Map<String, Object> map: resultList) {
			Product ps = new Product();
			ps.setId((int)map.get("id"));
			ps.setDescription((String)map.get("description"));
			ps.setName((String)map.get("name"));
			ps.setPrice((Float)map.get("price"));
			products.add(ps);
	}
		return products;
	}
	
	private static final String GET_PRODUCTSBYNAME_SQL="SELECT id, name,"
			+ "description,price FROM products WHERE name LIKE ?";
	@Override
	public List<Product> getProductsByName(Product product) {
		List<Map<String, Object>> resultList = jdbcOperations.queryForList(GET_PRODUCTSBYNAME_SQL, product.getName());	
		List<Product> products = new ArrayList<Product>();
		for(Map<String, Object> map: resultList) {
			Product ps = new Product();
			ps.setId((int)map.get("id"));
			ps.setDescription((String)map.get("description"));
			ps.setName((String)map.get("name"));
			ps.setPrice((Float)map.get("price"));
			products.add(ps);
		
		}
		return products;
	}
	
	
	
	@Override
	public void deleteProductsById(Product product) {
		// TODO Auto-generated method stub
		
	}
	
	private static final String SELECT_PRODUCTSBYID_SQL = "SELECT id, name,description,price FROM products WHERE id=?";
	@Override
	public Product getProductsById(Product product) {
		// TODO Auto-generated method stub
		Product result = jdbcOperations.queryForObject(SELECT_PRODUCTSBYID_SQL, new ProductRowMapper(), product.getId());	
		return result;
	}
	
	private static final class ProductRowMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			return new Product(			
			rs.getInt("id"),
			rs.getString("name"),
			rs.getString("description"),
			rs.getFloat("price"));
		}
		
	}

	@Override
	public void saveProductsById(Product product) {
		// TODO Auto-generated method stub
		
	}

//	private static final String GET_PRODUCTSBYNAME_SQL = "SELECT name,"
//			+ "description,price FROM products WHERE name LIKE ?";
//
//	public List<Product> getProductsByName(Product product) throws DAOException {
//		List<Product> products = new ArrayList<Product>();
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(GET_PRODUCTSBYNAME_SQL);
//			pStatement.setString(1, "%" + product.getName() + "%");
//			resultSet = pStatement.executeQuery();
//
//			while (resultSet.next()) {
//				// product=new Product();
//				product.setName(resultSet.getString("name"));
//				product.setDescription(resultSet.getString("description"));
//				product.setPrice(resultSet.getFloat("price"));
//				products.add(product);
//			}
//		} catch (SQLException e) {
//			throw new DAOException("Error getting products." + e.getMessage());
//		} finally {
//			closeDBObjects(resultSet, pStatement, connection);
//		}
//		return products;
//	}
//
//	private static final String DELETE_PRODUCTSBYID_SQL = "DELETE FROM products WHERE id=?";
//
//	@Override
//	public void deleteProductsById(Product product) throws DAOException {
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		// ResultSet resultSet=null;
//
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(DELETE_PRODUCTSBYID_SQL);
//			pStatement.setInt(1, product.getId());
//			int len = pStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			throw new DAOException("Error deletting products." + e.getMessage());
//		} finally {
//			closeDBObjects(null, pStatement, connection);
//		}
//
//	}
//
//	private static final String SELECT_PRODUCTSBYID_SQL = "SELECT name,description,price FROM products WHERE id=?";
//
//	@Override
//	public Product getProductsById(Product product) throws DAOException {
//		List<Product> products = new ArrayList<Product>();
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(SELECT_PRODUCTSBYID_SQL);
//			pStatement.setInt(1, product.getId());
//			resultSet = pStatement.executeQuery();
//
//			while (resultSet.next()) {
//				// product=new Product();
//				product.setName(resultSet.getString("name"));
//				product.setDescription(resultSet.getString("description"));
//				product.setPrice(resultSet.getFloat("price"));
//				products.add(product);
//			}
//		} catch (SQLException e) {
//			throw new DAOException("Error getting products." + e.getMessage());
//		} finally {
//			closeDBObjects(resultSet, pStatement, connection);
//		}
//		return products.get(0);
//	}
//
//	private static final String UPDATE_PRODUCT_SQL = "UPDATE products SET name=?,description=?,price=? WHERE id=?";
//
//	@Override
//	public void saveProductsById(Product product) throws DAOException {
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		try {
//			connection = getConnection();
//			pStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
//			pStatement.setString(1, product.getName());
//			pStatement.setString(2, product.getDescription());
//			pStatement.setFloat(3, product.getPrice());
//			pStatement.setInt(4, product.getId());
//			pStatement.execute();
//		} catch (SQLException e) {
//			throw new DAOException("Error adding product." + e.getMessage());
//
//		} finally {
//			closeDBObjects(null, pStatement, connection);
//		}
//	}

}
