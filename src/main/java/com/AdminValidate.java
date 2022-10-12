package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(value = "/AdminValidate", loadOnStartup = 1)
public class AdminValidate extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		String select = req.getParameter("option");
		
//		PrintWriter out = res.getWriter();
		RequestDispatcher rd = null;
		
		if(select.equals("employee")) {
			rd = req.getRequestDispatcher("superadmin.jsp");
			
		}
		else if(select.equals("admin")) {
			
		}
	}
}
