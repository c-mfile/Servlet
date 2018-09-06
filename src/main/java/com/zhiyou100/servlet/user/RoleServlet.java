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
import com.zhiyou100.pojo.Role;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;

public class RoleServlet extends HttpServlet {
	RoleService roleService = new RoleServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("roleList".equals(action)){
			List<Role> roles = roleService.findAll();
			req.setAttribute("rs", roles);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else if("roleDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			roleService.delete(id);
			resp.sendRedirect("roleList.do");
		}else if("roleDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			Role role = roleService.findById(id);
			req.setAttribute("role", role);
			req.getRequestDispatcher("detail.jsp").forward(req, resp);
		}else if("roleEdit".equals(action)){
			int id = Integer.parseInt(req.getParameter("rid"));
			Role role = roleService.findById(id);
			req.setAttribute("role", role);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("roleUpdate".equals(action)) {
			String name = req.getParameter("rName");
			String desc = req.getParameter("rDesc");
			int id = Integer.parseInt(req.getParameter("rId"));
			Role role = new Role(id, name, desc);
			roleService.update(role);
			resp.sendRedirect("roleList.do");
		}else if("roleAdd".equals(action)){
			String name = req.getParameter("rName");
			String desc = req.getParameter("rDesc");
			Role role = new Role(0, name, desc);
			roleService.add(role);
			resp.sendRedirect("roleList.do");
		}}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}

}
