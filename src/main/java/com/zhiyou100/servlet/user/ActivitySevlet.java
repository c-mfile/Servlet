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

import com.zhiyou100.pojo.Activity;
import com.zhiyou100.service.impl.ActivityServiceImpl;
import com.zhiyou100.service.ActivityService;

public class ActivitySevlet extends HttpServlet {
	ActivityService activityService = new ActivityServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("activityList".equals(action)){
			List<Activity> Activitys = activityService.findAll();
			req.setAttribute("as", Activitys);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else if("activityAdd".equals(action)){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String d = req.getParameter("aDate");
				Date date = new Date(sdf.parse(d).getTime());
				String theme = req.getParameter("aTheme");
				String content = req.getParameter("aContet");
				String site = req.getParameter("aSite");
				int cost = Integer.parseInt(req.getParameter("aCost"));
				String organizer = req.getParameter("aOrganizer");
				Activity activity = new Activity(0, date, theme, content, site, cost, organizer);
				activityService.add(activity);
				resp.sendRedirect("activityList.do");
			} catch (ParseException e) {
				e.printStackTrace();
				resp.sendRedirect("activityList.do");
			}
		}else if("activityEdit".equals(action)){
			int id = Integer.parseInt(req.getParameter("aid"));
			Activity activity = activityService.findById(id);
			req.setAttribute("activity", activity);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else if("activityUpdate".equals(action)){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				int id = Integer.parseInt(req.getParameter("aId"));
				String d = req.getParameter("aDate");
				Date date = new Date(sdf.parse(d).getTime());
				String theme = req.getParameter("aTheme");
				String content = req.getParameter("aContet");
				String site = req.getParameter("aSite");
				int cost = Integer.parseInt(req.getParameter("aCost"));
				String organizer = req.getParameter("aOrganizer");
				Activity activity = new Activity(id, date, theme, content, site, cost, organizer);
				activityService.update(activity);
				resp.sendRedirect("activityList.do");
			} catch (ParseException e) {
				e.printStackTrace();
				resp.sendRedirect("activityList.do");
			}
		}else if("ActivityDelete".equals(action)){
			int id = Integer.parseInt(req.getParameter("aid"));
			activityService.delete(id);
			resp.sendRedirect("activityList.do");
		}else if("activityDetail".equals(action)){
			int id = Integer.parseInt(req.getParameter("aid"));
			Activity activity = activityService.findById(id);
			req.setAttribute("activity", activity);
			req.getRequestDispatcher("/view/activity/detail.jsp").forward(req, resp);
		}
		}catch (Exception ex) {
			ex.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
