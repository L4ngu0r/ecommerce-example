package com.exemple.ecommerce.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersitenceManager {

	private static EntityManagerFactory emf;
	
	private PersitenceManager(){}
	
	public static EntityManagerFactory getEntityManagerFactory(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("Test-PU");
		}
		return emf;
	}
	
	public static void closeEntityManagerFactory(){
		if(emf != null && emf.isOpen()) emf.close();
	}
}
