package com.exemple.ecommerce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Set the username in session for auth
 * @author L4ngu0r
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = req.getParameter("username");
//		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		session.setAttribute("username", user);
		resp.sendRedirect(getServletContext().getContextPath()+"/list");
	}

	
}
