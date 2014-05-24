package com.exemple.ecommerce.dao;

import com.exemple.ecommerce.utils.PersitenceManager;

/**
 * Singleton DaoFactory
 * @author L4ngu0r
 *
 */
public class DaoFactory {

	private static DaoFactory instance;
	
	private ProductDaoBdd productDaoBdd;
	private ProductDaoMem productuDaoMem;
	private ProductDaoJpa productDaoJpa;
	
	public static DaoFactory getInstance(){
		if(instance == null) instance = new DaoFactory();
		return instance;
	}
	
	
	public ProductDaoBdd getProductDaoBdd(){
		if(productDaoBdd == null) productDaoBdd = new ProductDaoBdd();
		return productDaoBdd;
	}
	
	public ProductDaoMem getProductDaoMem(){
		if(productuDaoMem == null) productuDaoMem = new ProductDaoMem();
		return productuDaoMem;
	}
	
	public ProductDaoJpa getProductDaoJpa(){
		if(productDaoJpa == null){
			productDaoJpa = new ProductDaoJpa(PersitenceManager.getEntityManagerFactory());
		}
		return productDaoJpa;
	}
}

