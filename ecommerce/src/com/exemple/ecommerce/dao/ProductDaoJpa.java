package com.exemple.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.exemple.ecommerce.bean.Product;
import com.exemple.ecommerce.exceptions.UnknownProductException;

/**
 * JPA implementation of requests
 * @author L4ngu0r
 *
 */
public class ProductDaoJpa implements ProductInterface {

	private EntityManagerFactory emf;
	
	public ProductDaoJpa(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public List<Product> getAllProducts() {
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery("SELECT p FROM Product p");
			return query.getResultList();
		}finally{
			em.close();
		}
	}

	@Override
	public void addProduct(Product p) throws UnknownProductException {
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}finally{
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public Product findProduct(Long id) throws UnknownProductException {
		EntityManager em = emf.createEntityManager();
		try{
			return em.find(Product.class, id);
		}finally{
			em.close();
		}
	}

	@Override
	public void removeProduct(Long id) throws UnknownProductException {
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(em.find(Product.class, id));
			em.getTransaction().commit();
		}finally{
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void removeProduct(Product p) throws UnknownProductException {
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		}finally{
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void updateProduct(Product p) throws UnknownProductException {
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
		}finally{
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

}
