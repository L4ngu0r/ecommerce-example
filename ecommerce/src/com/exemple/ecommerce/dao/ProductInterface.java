package com.exemple.ecommerce.dao;

import java.util.List;

import com.exemple.ecommerce.bean.Product;
import com.exemple.ecommerce.exceptions.UnknownProductException;

/**
 * Interface which determine methods to implements in DAO
 * @author L4ngu0r
 *
 */
public interface ProductInterface {
	
	/**
	 * Return all the products store in database or memory
	 * @return List<Product>
	 */
	public List<Product> getAllProducts();
	
	/**
	 * Add a product
	 * @param p Product
	 * @throws UnknownProductException
	 */
	public void addProduct(Product p) throws UnknownProductException;
	
	/**
	 * Find a product by his id and return it.
	 * Id must exist.
	 * @param id Long
	 * @return Product
	 * @throws UnknownProductException
	 */
	public Product findProduct(Long id) throws UnknownProductException;
	
	/**
	 * Remove a product from it's id
	 * @param id Long
	 * @throws UnknownProductException
	 */
	public void removeProduct(Long id) throws UnknownProductException;
	
	/**
	 * Remove a product
	 * @param p Product
	 * @throws UnknownProductException
	 */
	public void removeProduct(Product p) throws UnknownProductException;
	
	/**
	 * Merge a product
	 * @param p Product
	 * @throws UnknownProductException
	 */
	public void updateProduct(Product p) throws UnknownProductException;
}
