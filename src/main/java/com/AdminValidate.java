package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(value = "/AdminValidate", loadOnStartup = 1)
public class AdminValidate extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		
		String select = req.getParameter("option");
		
//		PrintWriter out = res.getWriter();
//		out.print(select);
		
		Map<String, String> m = new HashMap<>();
		Repo r = new Repo();
		
		try {
			ResultSet rs = r.getEmployeeDetails(select);
			while(rs.next()) {
				m.put(rs.getString(1), rs.getString(2));
			}
			req.setAttribute("select", select);
			req.setAttribute("data", m);
			
		} catch (SQLException e) {
			System.out.println("Admin Validate: "+e.getMessage());
		}
		
		if(select.equals("employee")) {
			rd = req.getRequestDispatcher("jsp/superadmin.jsp");
			rd.include(req, res);
		}
		else if(select.equals("admin")) {
			rd = req.getRequestDispatcher("jsp/superadmin.jsp");
			rd.include(req, res);
		}else if(select.equals("super admin")) {
			rd = req.getRequestDispatcher("jsp/superadmin.jsp");
			rd.include(req, res);
		}
	}
}
