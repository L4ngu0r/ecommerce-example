package com.exemple.ecommerce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemple.ecommerce.bean.Product;
import com.exemple.ecommerce.dao.DaoFactory;
import com.exemple.ecommerce.dao.ProductDaoJpa;

/**
 * Get all the products in database and retrieve it to jsp page
 * @author Steven
 *
 */
@WebServlet("/list")
public class ListProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProductDaoJpa productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getInstance().getProductDaoJpa();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Product> liste = productDao.getAllProducts();
		req.setAttribute("liste", liste);
		req.getRequestDispatcher("/listProduct.jsp").forward(req, resp);
	}

	
}
