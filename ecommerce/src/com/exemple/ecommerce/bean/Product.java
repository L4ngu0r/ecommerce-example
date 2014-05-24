package com.exemple.ecommerce.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean Product
 * @author L4ngu0r
 */
@Entity
@Table(name = "products")
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	private float price;
	
	public Product(){
		
	}
	
	public Product(String nom, String description, float price) {
		this.nom = nom;
		this.description = description;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
