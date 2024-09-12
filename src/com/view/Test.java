package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductServiceImpl;
import com.service.ProductService;

public class Test {
	
	public static void main(String[] args) {
		
		//addBtn();
		//getAll();
		//deleteBtn();
		updateBtn();
		
	}
	
	
	//add product
	static void addBtn() {
		
		ProductService service = new ProductServiceImpl();
		
		char flag = 'y';
		Scanner sc = new Scanner(System.in);
		
		do {
			Product pd = new Product();
			
//			System.out.println("Enter id: ");
//			pd.setId(sc.nextInt());
			
			System.out.println("Enter name: ");
			pd.setName(sc.next());
			
			System.out.println("Enter company: ");
			pd.setCompany(sc.next());
			
			System.out.println("Enter price: ");
			pd.setPrice(sc.nextInt());
			
			service.addProduct(pd);
			
			System.out.println("Do you want to add more[y/n] :");
			flag = sc.next().charAt(0);
		}while(flag == 'y');
	}
	
	//get all products
	static void getAll() {
		
		ProductService service = new ProductServiceImpl();
		List<Product> plist = service.getAllProducts();
		System.out.println(plist);
	}
	
	//delete product
	static void deleteBtn() {
		
		ProductService service = new ProductServiceImpl();
		service.deleteProduct(5);
		
		//show products after deletion
		//getAll();
	}
	
	static void updateBtn() {
		ProductService service = new ProductServiceImpl();
		service.updateProduct(2);
	}
	

}
