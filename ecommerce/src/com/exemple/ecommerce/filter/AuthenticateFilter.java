package com.exemple.ecommerce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter verify if the user is logged and redirect to the form if not.
 * @author L4ngu0r
 *
 */
@WebFilter("/auth/*")
public class AuthenticateFilter implements Filter {

	private FilterConfig config = null;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		if(req instanceof HttpServletRequest && resp instanceof HttpServletResponse){
			HttpServletRequest request = (HttpServletRequest) req;		//casting for using session
			HttpServletResponse response = (HttpServletResponse) resp;	//casting for using sendRedirect
			String username = (String) request.getSession().getAttribute("username");
			if(username == null || username == ""){						//BEWARE : simply verification on username just for demo
				response.sendRedirect(config.getServletContext().getContextPath()+"/login");
				return;
			}
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		this.config = null;
	}
}
