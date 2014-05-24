package com.exemple.ecommerce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemple.ecommerce.dao.DaoFactory;
import com.exemple.ecommerce.dao.ProductDaoJpa;
import com.exemple.ecommerce.exceptions.UnknownProductException;

/**
 * Remove a product from database
 * @author L4ngu0r
 *
 */
@WebServlet("/auth/remove")
public class RemoveProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductDaoJpa productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getInstance().getProductDaoJpa();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		
		try {
			Long idLong = Long.parseLong(id);
			productDao.removeProduct(idLong);
			resp.sendRedirect(getServletContext().getContextPath()+"/list");
		} catch(NumberFormatException e){
			e.printStackTrace();
		} catch (UnknownProductException e) {
			e.printStackTrace();
		}
	}

	
}
