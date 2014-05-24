package com.exemple.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.exemple.ecommerce.bdd.Connexion;
import com.exemple.ecommerce.bean.Product;
import com.exemple.ecommerce.exceptions.UnknownProductException;

public class ProductDaoBdd implements ProductInterface {
	
	private Connection connexion = null;
	private Connexion co;

	public ProductDaoBdd(){
		try {
			co = new Connexion("jdbc:mysql://localhost:3306/formation", "root", "admin", "com.mysql.jdbc.Driver");
			connexion = co.getConnex();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Product> getAllProducts() {
		
		List<Product> products = new ArrayList<Product>(100);
		 
		try {
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT id,nom,description,price FROM products");
			
			while(rs.next()){
				Product temp = new Product();
				temp.setId(rs.getLong("id"));
				temp.setNom(rs.getString("nom"));
				temp.setDescription(rs.getString("description"));
				temp.setPrice(rs.getFloat("price"));
				products.add(temp);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.unmodifiableList(products);
	}

	@Override
	public void addProduct(Product p) throws UnknownProductException {
		if(p != null){
			try {
				PreparedStatement ps = connexion.prepareStatement("INSERT INTO products (nom,description,price) VALUES (?,?,?)");
				ps.setString(1, p.getNom());
				ps.setString(2, p.getDescription());
				ps.setFloat(3, p.getPrice());
				ps.executeUpdate();
				ps.close();
				System.out.println("Product added into database");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			throw new UnknownProductException("Product null, please verify your parameter");
		}
	}

	@Override
	public Product findProduct(Long id) throws UnknownProductException {
		Product t = new Product();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT id,nom,description,price FROM products WHERE products.id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				t.setId(rs.getLong("id"));
				t.setNom(rs.getString("nom"));
				t.setDescription(rs.getString("description"));
				t.setPrice(rs.getFloat("price"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public void removeProduct(Long id) throws UnknownProductException {
		try {
			PreparedStatement ps = connexion.prepareStatement("DELETE FROM products WHERE products.id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeProduct(Product p) throws UnknownProductException {
		if(p != null){
			removeProduct(p.getId());
		}else{
			throw new UnknownProductException("Product null, please verify your parameter");
		}
	}

	@Override
	public void updateProduct(Product p) throws UnknownProductException {
		if(p != null){
			try {
				PreparedStatement ps = connexion.prepareStatement("UPDATE products SET nom = ?, description = ?, price = ? WHERE products.id = ?");
				ps.setString(1, p.getNom());
				ps.setString(2, p.getDescription());
				ps.setFloat(3, p.getPrice());
				ps.setLong(4, p.getId());
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			throw new UnknownProductException("Product null, please verify your parameter");
		}
	}

}
