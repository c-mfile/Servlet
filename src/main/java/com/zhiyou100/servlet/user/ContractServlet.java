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

import com.zhiyou100.pojo.Contract;
import com.zhiyou100.pojo.House;
import com.zhiyou100.pojo.Lessee;
import com.zhiyou100.service.ContractService;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.LesseeService;
import com.zhiyou100.service.impl.ContractServiceImpl;
import com.zhiyou100.service.impl.HouseServiceImpl;
import com.zhiyou100.service.impl.LesseeServiceImpl;

public class ContractServlet extends HttpServlet {
	ContractService contractService = new ContractServiceImpl();
	HouseService houseService = new HouseServiceImpl();
	LesseeService lesseeService = new LesseeServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("contractList".equals(action)){
			List<Contract> cs = contractService.findAll();
			req.setAttribute("cs", cs);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}if("contractAdd".equals(action)){
			try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Integer hid = Integer.parseInt(req.getParameter("hId"));
			Integer LId = Integer.parseInt(req.getParameter("lId"));
			String cstart = req.getParameter("cStartTime");
			String cend = req.getParameter("cEndTime");
			Date endTime = new Date(sdf.parse(cend).getTime());			Date startTime = new Date(sdf.parse(cstart).getTime());;
			Date date = new Date(System.currentTimeMillis());
			Integer aliquilter = Integer.parseInt(req.getParameter("cAliquilter"));
			String pay = req.getParameter("cPay");
			Integer deptsito = Integer.parseInt(req.getParameter("cDeptsito"));
			Integer paynum = Integer.parseInt(req.getParameter("cPaynum"));
			String name = req.getParameter("cName");
			Integer status = Integer.parseInt(req.getParameter("cStatus"));
			Contract c = new Contract(0, hid, LId, date, startTime, endTime, aliquilter, pay, deptsito, paynum, name, status);
			contractService.add(c);
			resp.sendRedirect("contractList.do");
			}catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}else if("add".equals(action)){
			List<House> hs = houseService.findAll();
			List<Lessee> ls = lesseeService.findAll();
			req.setAttribute("hs", hs);
			req.setAttribute("ls", ls);
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}else if("contractDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("cid"));
			Contract contract = contractService.findById(id);
			req.setAttribute("i", contract);
			req.getRequestDispatcher("detail.jsp").forward(req, resp);
		}else if("contractEdit".equals(action)){
			int id = Integer.parseInt(req.getParameter("cid"));
			Contract contract = contractService.findById(id);
			req.setAttribute("i", contract);
			List<House> hs = houseService.findAll();
			List<Lessee> ls = lesseeService.findAll();
			req.setAttribute("hs", hs);
			req.setAttribute("ls", ls);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("contractUpdate".equals(action)){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Integer hid = Integer.parseInt(req.getParameter("hId"));
				Integer LId = Integer.parseInt(req.getParameter("lId"));
				String cstart = req.getParameter("cStartTime");
				String cend = req.getParameter("cEndTime");
				Date endTime = new Date(sdf.parse(cend).getTime());
				Date startTime = new Date(sdf.parse(cstart).getTime());
				Date date = new Date(System.currentTimeMillis());
				Integer aliquilter = Integer.parseInt(req.getParameter("cAliquilter"));
				String pay = req.getParameter("cPay");
				Integer deptsito = Integer.parseInt(req.getParameter("cDeptsito"));
				Integer paynum = Integer.parseInt(req.getParameter("cPaynum"));
				String name = req.getParameter("cName");
				Integer status = Integer.parseInt(req.getParameter("cStatus"));
				Contract c = new Contract(0, hid, LId, date, startTime, endTime, aliquilter, pay, deptsito, paynum, name, status);
				contractService.update(c);
				resp.sendRedirect("contractList.do");
				}catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		}else if("contractDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("cid"));
			contractService.delete(id);
			resp.sendRedirect("contractList.do");
		}}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
