package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.model.Product;

public class ProductServiceImpl implements ProductService {
	
	static List<Product> plist = new ArrayList<>();

	@Override
	public void addProduct(Product prod) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mnjsss123");
			
			String sql = "insert into product(name,company,price)values('"+prod.getName()+"','"+prod.getCompany()+"','"+prod.getPrice()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		plist.add(prod);
//		System.out.println("----added success----size = "+plist.size());
	}

	@Override
	public void deleteProduct(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mnjsss123");
			
			String sql = "delete from product where id = '"+id+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			
			System.out.println("success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		plist.remove(index);
	}

	@Override
	public List<Product> getAllProducts() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mnjsss123");
			
			String sql = "select * from product";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				System.out.println("Id = "+rs.getInt("id"));
				System.out.println("Product = "+rs.getString("name"));
				System.out.println("Company = "+rs.getString("company"));
				System.out.println("Price = "+rs.getInt("price"));
				System.out.println("----------------------");
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public void updateProduct(int id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mnjsss123");
			
			String sql = "update product set price = '9999' where id = '"+id+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			
			con.close();
			System.out.println("success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
