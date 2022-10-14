package com;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.bean.Template;
import com.bean.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(value = "/assignTemplateDetails", loadOnStartup = 1)
public class AssignTemplateDetails extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataOperations d = new DataOperations();
		List<Users> ename = new ArrayList();
		List<Template> tname = new ArrayList();
		Users u=null;
		try {
			ename = d.getUsersDetails("employee");
//			System.out.println("hellloo");

			req.setAttribute("employees",ename);
			tname = d.getAllTemplate();
//			System.out.println("hellloo");

			req.setAttribute("templates",tname);
			RequestDispatcher rd=req.getRequestDispatcher("jsp/assignTemplate.jsp");
			rd.forward(req, resp);
//			System.out.println("hellloo");
			
			
		} catch (SQLException e) {
			System.out.println("Assigned Template"+e.getMessage());
		}
	}
}
