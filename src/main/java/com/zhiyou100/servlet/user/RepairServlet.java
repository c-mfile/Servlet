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

import com.zhiyou100.pojo.House;
import com.zhiyou100.pojo.Lessee;
import com.zhiyou100.pojo.Logistica;
import com.zhiyou100.pojo.Repair;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.LogisticalService;
import com.zhiyou100.service.RepairService;
import com.zhiyou100.service.impl.HouseServiceImpl;
import com.zhiyou100.service.impl.LogisticalServiceImpl;
import com.zhiyou100.service.impl.RepairServiceImpl;

public class RepairServlet extends HttpServlet {
	RepairService repairService = new RepairServiceImpl();
	HouseService houseService = new HouseServiceImpl();
	LogisticalService logService = new LogisticalServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("repairList".equals(action)){
			List<Repair> rs = repairService.findAll();
			req.setAttribute("rs", rs);			
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}if("repairAdd".equals(action)){
			try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int message = Integer.parseInt(req.getParameter("rMessage"));
			int pincipal = Integer.parseInt(req.getParameter("rPrincipal"));
			String explain = req.getParameter("rExplain");
			String t = req.getParameter("rTime");
			Date date = new Date(sdf.parse(t).getTime());
			String result = req.getParameter("rResult");
			String remark = req.getParameter("rRemark");
			Repair re = new Repair(0, message, pincipal, explain, date, result, remark);
			repairService.add(re);
			resp.sendRedirect("repairList.do");
			}catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}else if("add".equals(action)){
			List<House> houses = houseService.findAll();
			List<Logistica> logs = logService.findAll();
			req.setAttribute("houses", houses);
			req.setAttribute("logs", logs);
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}else if("repairDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			Repair repair = repairService.findById(id);
			req.setAttribute("repair", repair);
			req.getRequestDispatcher("detail.jsp").forward(req, resp);
		}else if("repairEdit".equals(action)){
			List<House> houses = houseService.findAll();
			List<Logistica> logs = logService.findAll();
			req.setAttribute("houses", houses);
			req.setAttribute("logs", logs);
			int id = Integer.parseInt(req.getParameter("rid"));
			Repair repair = repairService.findById(id);
			req.setAttribute("repair", repair);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("repairUpdate".equals(action)){
			try {
				int id = Integer.parseInt(req.getParameter("reId"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				int message = Integer.parseInt(req.getParameter("rMessage"));
				int pincipal = Integer.parseInt(req.getParameter("rPrincipal"));
				String explain = req.getParameter("rExplain");
				String t = req.getParameter("rTime");
				Date date = new Date(sdf.parse(t).getTime());
				String result = req.getParameter("rResult");
				String remark = req.getParameter("rRemark");
				Repair re = new Repair(id, message, pincipal, explain, date, result, remark);
				repairService.update(re);
				resp.sendRedirect("repairList.do");
				}catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		}else if("repairDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			repairService.delete(id);
			resp.sendRedirect("repairList.do");
		}}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}

}
