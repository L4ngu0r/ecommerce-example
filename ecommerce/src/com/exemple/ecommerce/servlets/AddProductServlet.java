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
 * Servlet : add a product by the form on page addProduct.jsp
 * @author L4ngu0r
 *
 */
@WebServlet("/auth/add")
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = -6285999648959905154L;
	
	private ProductDaoJpa productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getInstance().getProductDaoJpa();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/auth/addProduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String desc = req.getParameter("desc");
		String price = req.getParameter("price");
		float prix;
		try{
			prix = Float.parseFloat(price);
			Product pTemp = new Product(nom,desc,prix);
			productDao.addProduct(pTemp);
		}catch(NumberFormatException e){
			e.printStackTrace();
		} catch (UnknownProductException e) {
			e.printStackTrace();
		}
		resp.sendRedirect(getServletContext().getContextPath()+"/list");
	}

	
}
