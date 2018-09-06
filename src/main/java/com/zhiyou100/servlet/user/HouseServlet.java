package com.zhiyou100.servlet.user;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zhiyou100.pojo.House;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.impl.HouseServiceImpl;
import com.zhiyou100.util.DBUtil;
import com.zhiyou100.util.FileUpload;
@MultipartConfig
public class HouseServlet extends HttpServlet {

	HouseService houseService = new HouseServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("houseAdd".equals(action)){
			String harea = req.getParameter("hArea");
			String estate = req.getParameter("hEstate");
			String unitnumber = req.getParameter("hUnIntegerNumber");
			int floor = Integer.valueOf(req.getParameter("hFloor"));
			String roomno = req.getParameter("hRoomno");
			String acreage = req.getParameter("hAcreage");
			String direction = req.getParameter("hDirection");
			String fitment = req.getParameter("hFitment");
			boolean isdoubleair = Integer.valueOf(req.getParameter("hIsdoubleair")) != null;
			int limit = Integer.valueOf(req.getParameter("hLimit"));
			String facility = req.getParameter("hFacility");
			int price = Integer.valueOf(req.getParameter("hPrice"));
			int status = Integer.valueOf(req.getParameter("hStatus"));
			String img = req.getParameter("hImg");
			String address = req.getParameter("hAddress");
			Date date = new Date(System.currentTimeMillis());
			House h = new House(0, harea, estate, unitnumber, floor, roomno, acreage, direction, fitment, isdoubleair, limit, facility, price, status, img, address, date, date);
			houseService.add(h);
			resp.sendRedirect("houseList.do");
		}else if("houseList".equals(action)){
			List<House> houses = houseService.findAll();
			System.out.println(houses);
			req.getSession().setAttribute("houses", houses);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else if("houseDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("hid"));
			House house = houseService.findById(id);
			req.setAttribute("house", house);
			req.getRequestDispatcher("/view/flats/detail.jsp").forward(req, resp);
		}else if("houseEdit".equals(action)){
			int id = Integer.parseInt(req.getParameter("hid"));
			House house = houseService.findById(id);
			req.setAttribute("house", house);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("houseUpdate".equals(action)){
			int id = Integer.parseInt(req.getParameter("hId"));
			String harea = req.getParameter("hArea");
			String estate = req.getParameter("hEstate");
			String unitnumber = req.getParameter("hUnIntegerNumber");
			int floor = Integer.valueOf(req.getParameter("hFloor"));
			String roomno = req.getParameter("hRoomno");
			String acreage = req.getParameter("hAcreage");
			String direction = req.getParameter("hDirection");
			String fitment = req.getParameter("hFitment");
			boolean isdoubleair = Integer.valueOf(req.getParameter("hIsdoubleair")) != null;
			int limit = Integer.valueOf(req.getParameter("hLimit"));
			String facility = req.getParameter("hFacility");
			int price = Integer.valueOf(req.getParameter("hPrice"));
			int status = Integer.valueOf(req.getParameter("hStatus"));
			Part filename=req.getPart("hImg");
			String img=FileUpload.upload(filename);
			String address = req.getParameter("hAddress");
			Date date = new Date(System.currentTimeMillis());
			House h = new House(id, harea, estate, unitnumber, floor, roomno, acreage, direction, fitment, isdoubleair, limit, facility, price, status, img, address, date, date);
			houseService.update(h);
			resp.sendRedirect("houseList.do");
		}else if("houseDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("hid"));
			houseService.delete(id);
			resp.sendRedirect("houseList.do");
		}}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}
	

}
