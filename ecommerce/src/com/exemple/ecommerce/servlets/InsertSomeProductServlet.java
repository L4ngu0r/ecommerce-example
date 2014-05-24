package com.exemple.ecommerce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemple.ecommerce.bean.Product;
import com.exemple.ecommerce.dao.DaoFactory;
import com.exemple.ecommerce.dao.ProductDaoJpa;
import com.exemple.ecommerce.exceptions.UnknownProductException;

/**
 * Insert some random product to populate the databse
 * @author L4ngu0r
 *
 */
@WebServlet("/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDaoJpa productDao;
		
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getInstance().getProductDaoJpa();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Product p = new Product("Nexus","Smartphone Google",350);
		try {
			productDao.addProduct(p);
		} catch (UnknownProductException e) {
			e.printStackTrace();
		}
	}
       
    
}
