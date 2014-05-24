package com.exemple.ecommerce.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.exemple.ecommerce.utils.PersitenceManager;

@WebListener
public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		PersitenceManager.closeEntityManagerFactory();
		System.out.println("Contexte de l'application détruit");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Contexte de l'application initialisé");		
	}

}
