package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.bean.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.Response;

@WebServlet(value = "/Controller", loadOnStartup = 1)
public class Controller extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		DataOperations r = new DataOperations();
		PrintWriter out = res.getWriter();
		String res1 = null;
		try {
			res1 = r.check(name, password);
		} catch (SQLException e) {
			out.print("Sorry enter the correct details!");
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
		String select = "select";
		req.setAttribute("select", select);
		if (res1!=null && res1.equals("admin")) {
			rd = req.getRequestDispatcher("jsp/admin.jsp");
			rd.forward(req, res);

		} else if (res1!=null && res1.equals("employee")) {
			rd = req.getRequestDispatcher("jsp/employee.jsp");
			rd.forward(req, res);

		} else if (res1!=null && res1.equals("super admin")) {
			rd = req.getRequestDispatcher("jsp/superadmin.jsp");
			rd.forward(req, res);
		}
	}
}
