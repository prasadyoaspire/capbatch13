package com.ecom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ecom.bean.Product;

public class ProductDao {

	public Product getProductById(int productId) {
		
		String url = "jdbc:postgresql://localhost:5432/batch13db";
		String username = "batch13";
		String password = "batch13";
		String sql = "select * from product_tbl where product_id = ?";
		
		Connection con = null;
		Product product = null;
		
		try {
			con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int pid = rs.getInt(1);
				String pname = rs.getString(2);
				float pprice = rs.getFloat(3);
				String pcategory = rs.getString(4);
				Date sqlDate = rs.getDate(5);
				//convert sqlDate to LocalDate 
				LocalDate pcreatedOn = sqlDate.toLocalDate();
				
				product = new Product();
				product.setProductId(pid);
				product.setProductName(pname);
				product.setProductPrice(pprice);
				product.setCategory(pcategory);
				product.setCreatedOn(pcreatedOn);
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return product;		
	}
	
	
	
	
	
	
}
