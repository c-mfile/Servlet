package com.zhiyou100.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.pojo.House;
import com.zhiyou100.pojo.Privilege;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.PrivilegeService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.HouseServiceImpl;
import com.zhiyou100.service.impl.PrivilegeServiceImpl;
import com.zhiyou100.service.impl.UserServiceImpl;


public class UserServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();
	HouseService houseService = new HouseServiceImpl();
	PrivilegeService privilegeService = new PrivilegeServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			String uri = req.getRequestURI();
			String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
			if("userlogin".equals(action)){
				String name = req.getParameter("username");
				String password = req.getParameter("password");
				String vcode = req.getParameter("vcode");
				User b = userService.login(name, password);
				if(b!=null){
					String code = (String) req.getSession().getAttribute("code");
					if(code.equals(vcode)){
						req.getSession().setAttribute("username", name);
						List<House> houses = houseService.findAll();
						req.getSession().setAttribute("houses", houses);
						Role role = userService.findRole(b.getuId());
						List<Privilege> privileges = privilegeService.findAllByRole(role);
						req.setAttribute("privileges", privileges);
						req.getSession().setAttribute("role", role);
						req.getRequestDispatcher("admin.jsp").forward(req, resp);
					}else{
						req.setAttribute("msg", "验证码错误");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
				}else{
					req.setAttribute("msg", "用户名或密码错误");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}else if("userList".equals(action)){
				req.setAttribute("users", userService.findAll());
				req.getRequestDispatcher("list.jsp").forward(req, resp);
			}else if("userAdd".equals(action)){
				String username = req.getParameter("uUsername");
				String password = req.getParameter("uPassword");
				String tel = req.getParameter("uTel");
				String name = req.getParameter("uName");
				String status = req.getParameter("uStatus");
				User u = new User(0, username, password, name, tel, status);
				userService.add(u);
				resp.sendRedirect("userList.do");
			}else if("userDetail".equals(action)){
				int id = Integer.parseInt(req.getParameter("uid"));
				User user = userService.findById(id);
				req.setAttribute("user", user);
				req.getRequestDispatcher("detail.jsp").forward(req, resp);
			}else if("userEdit".equals(action)){
				int id = Integer.parseInt(req.getParameter("uid"));
				User user = userService.findById(id);
				req.setAttribute("user", user);
				req.getRequestDispatcher("edit.jsp").forward(req, resp);
			}else if("userUpdate".equals(action)){
				int id = Integer.parseInt(req.getParameter("uId"));
				String username = req.getParameter("uUsername");
				String password = req.getParameter("uPassword");
				String tel = req.getParameter("uTel");
				String name = req.getParameter("uName");
				String status = req.getParameter("uStatus");
				User u = new User(id, username, password, name, tel, status);
				userService.update(u);
				resp.sendRedirect("userList.do");
			}else if("userDelete".equals(action)){
				int id = Integer.parseInt(req.getParameter("uid"));
				userService.delete(id);
				resp.sendRedirect("userList.do");
			}else if("exit".equals(action)){
				req.getSession().invalidate();
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
