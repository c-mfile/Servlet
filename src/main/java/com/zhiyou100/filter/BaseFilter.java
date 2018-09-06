package com.zhiyou100.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class BaseFilter implements Filter {
     
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest  req =(HttpServletRequest)request;
        HttpServletResponse  resp =(HttpServletResponse)response;
		try{			
	        String uri = req.getRequestURI();
	        String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
	        if("userlogin".equals(action)){
	        	chain.doFilter(req, resp);
	        }else{
	        	Object username = req.getSession().getAttribute("username");
	        	if(username!=null){
	        		chain.doFilter(req, resp);
	        	}else{
	        		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	        	}
	        }
		}catch (Exception e) {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}
	
	public void destroy() {
		
	}

}
