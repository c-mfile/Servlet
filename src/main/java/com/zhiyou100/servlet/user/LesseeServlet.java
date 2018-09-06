package com.zhiyou100.servlet.user;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.pojo.Lessee;
import com.zhiyou100.service.LesseeService;
import com.zhiyou100.service.impl.LesseeServiceImpl;

public class LesseeServlet extends HttpServlet {
	LesseeService lesseeService = new LesseeServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("lesseeList".equals(action)){
			List<Lessee> lessees = lesseeService.findAll();
			req.setAttribute("ls", lessees);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else if("lesseeAdd".equals(action)){
			String name = req.getParameter("lName");
			String tel = req.getParameter("lTel");
			char sex = req.getParameter("lSex").charAt(0);
			String nativePlace = req.getParameter("lNativePlace");
			String idcate = req.getParameter("lIdcade");
			Date date = new Date(System.currentTimeMillis());
			Lessee l = new Lessee(0, name, tel, sex, nativePlace, idcate, date);
			lesseeService.add(l);
			resp.sendRedirect("lesseeList.do");
		}else if("lesseeEdit".equals(action)){
			int id = Integer.parseInt(req.getParameter("lid"));
			Lessee lessee = lesseeService.findById(id);
			req.setAttribute("lessee", lessee);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("lesseeUpdate".equals(action)){
			int id = Integer.parseInt(req.getParameter("lId"));
			String name = req.getParameter("lName");
			String tel = req.getParameter("lTel");
			char sex = req.getParameter("lSex").charAt(0);
			String nativePlace = req.getParameter("lNativePlace");
			String idcate = req.getParameter("lIdcade");
			Lessee l = new Lessee(id, name, tel, sex, nativePlace, idcate, null);
			lesseeService.update(l);
			resp.sendRedirect("lesseeList.do");
		}else if("lesseeDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("lid"));
			lesseeService.delete(id);
			resp.sendRedirect("lesseeList.do");
		}else if("lesseeDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("lid"));
			Lessee lessee = lesseeService.findById(id);
			req.setAttribute("lessee", lessee);
			req.getRequestDispatcher("/view/lessee/detail.jsp").forward(req, resp);
		}}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
