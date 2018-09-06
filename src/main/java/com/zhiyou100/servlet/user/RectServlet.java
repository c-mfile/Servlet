package com.zhiyou100.servlet.user;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.pojo.House;
import com.zhiyou100.pojo.Lessee;
import com.zhiyou100.pojo.Rect;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.LesseeService;
import com.zhiyou100.service.RectService;
import com.zhiyou100.service.impl.HouseServiceImpl;
import com.zhiyou100.service.impl.LesseeServiceImpl;
import com.zhiyou100.service.impl.RectServiceImpl;

public class RectServlet extends HttpServlet {
	RectService rectService = new RectServiceImpl();
	HouseService houseService = new HouseServiceImpl();
	LesseeService lesseeService = new LesseeServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("rectList".equals(action)){
			List<Rect> rects = rectService.findAll();
			req.setAttribute("rs", rects);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else if("rectDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			rectService.delete(id);
			resp.sendRedirect("rectList.do");
		}else if("rectDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			Rect rect = rectService.findById(id);
			req.setAttribute("rect", rect);
			req.getRequestDispatcher("detail.jsp").forward(req, resp);
		}else if("rectEdit".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			List<House> houses = houseService.findAll();
			List<Lessee> lessees = lesseeService.findAll();
			req.setAttribute("hs", houses);
			req.setAttribute("ls", lessees);
			Rect rect = rectService.findById(id);
			req.setAttribute("rect", rect);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("add".equals(action)){
			List<House> houses = houseService.findAll();
			List<Lessee> lessees = lesseeService.findAll();
			req.setAttribute("hs", houses);
			req.setAttribute("ls", lessees);
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		} else if("rectUpdate".equals(action)) {
			int rid = Integer.parseInt(req.getParameter("rId"));
			int hid = Integer.parseInt(req.getParameter("hId"));
			int lid = Integer.parseInt(req.getParameter("lId"));
			int money = Integer.parseInt(req.getParameter("rMoney"));
			String remark = req.getParameter("rRemark");
			Rect rect = new Rect(rid, hid, lid, money, null, remark);
			rectService.update(rect);
			resp.sendRedirect("rectList.do");
		}else if("rectAdd".equals(action)){
			int hid = Integer.parseInt(req.getParameter("hId"));
			int lid = Integer.parseInt(req.getParameter("lId"));
			int money = Integer.parseInt(req.getParameter("rMoney"));
			String remark = req.getParameter("rRemark");
			Date date = new Date(System.currentTimeMillis());
			Rect r = new Rect(0, hid, lid, money, date, remark);
			rectService.add(r);
			resp.sendRedirect("rectList.do");
		}}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}

}
