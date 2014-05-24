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
 * Get a product by id and retrieve it to jsp page
 * @author L4ngu0r
 *
 */
@WebServlet("/show")
public class ShowProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ProductDaoJpa productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getInstance().getProductDaoJpa();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param = req.getParameter("id");
		Long idTemp = null;
		try{
			idTemp = Long.parseLong(param);
			Product p = productDao.findProduct(idTemp);
			req.setAttribute("product", p);
			req.getRequestDispatcher("/showProduct.jsp").forward(req, resp);
		}catch(NumberFormatException e){
			e.printStackTrace();			//redirect to error page
		} catch (UnknownProductException e) {
			e.printStackTrace();
		}
	}

	
}
