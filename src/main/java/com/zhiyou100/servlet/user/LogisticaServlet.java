package com.zhiyou100.servlet.user;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.pojo.Logistica;
import com.zhiyou100.pojo.Rect;
import com.zhiyou100.service.LogisticalService;
import com.zhiyou100.service.impl.LogisticalServiceImpl;

public class LogisticaServlet extends HttpServlet {
	LogisticalService logisticalService = new LogisticalServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("logisticaList".equals(action)){
			List<Logistica> las = logisticalService.findAll();
			req.setAttribute("las", las);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else if("logisticaAdd".equals(action)){
			String name = req.getParameter("laName");
			String idcard = req.getParameter("laIdcard");
			String tel = req.getParameter("laTel");
			Integer salary = Integer.parseInt(req.getParameter("laSalary"));
			String sex = req.getParameter("laSex");
			String dept = req.getParameter("laDept");
			String hogar = req.getParameter("laHogar");
			Date date = new Date(System.currentTimeMillis());
			Logistica l = new Logistica(0, name, idcard, tel, sex, dept, date, salary, hogar);
			logisticalService.add(l);
			resp.sendRedirect("logisticaList.do");
		}else if("logisticaDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("laid"));
			req.setAttribute("log", logisticalService.findById(id));
			req.getRequestDispatcher("/view/logistica/detail.jsp").forward(req, resp);
		}else if("logisticaEdit".equals(action)){
			int id = Integer.parseInt(req.getParameter("laid"));
			req.setAttribute("log", logisticalService.findById(id));
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("logisticaUpdate".equals(action)){
			Integer id = Integer.parseInt(req.getParameter("laId"));
			String name = req.getParameter("laName");
			String idcard = req.getParameter("laIdcard");
			String tel = req.getParameter("laTel");
			Integer salary = Integer.parseInt(req.getParameter("laSalary"));
			String sex = req.getParameter("laSex");
			String dept = req.getParameter("laDept");
			String hogar = req.getParameter("laHogar");
			Logistica log = new Logistica(id, name, idcard, tel, sex, dept, null, salary, hogar);
			logisticalService.update(log);
			resp.sendRedirect("logisticaList.do");
		}else if("logisticaDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("laid"));
			logisticalService.delete(id);
			resp.sendRedirect("logisticaList.do");
		}}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
