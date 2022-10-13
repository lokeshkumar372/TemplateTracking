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

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;

		String select = req.getParameter("option");

//		PrintWriter out = res.getWriter();
//		out.print(select);

		Map<String, String> m = new HashMap<>();
<<<<<<< HEAD
		DataOperations r = new DataOperations();

		try {
			ResultSet rs = r.getUserDetails(select);
			while (rs.next()) {
=======
		Repo r = new Repo();
		
		
		
		try {
			ResultSet rs = r.getUsersDetails(select);
			while(rs.next()) {
>>>>>>> 324c080a69022d73491493a30f1766b13cae8371
				m.put(rs.getString(1), rs.getString(2));
			}
			req.setAttribute("select", select);
			req.setAttribute("data", m);

		} catch (SQLException e) {
			System.out.println("Admin Validate: " + e.getMessage());
		}

		rd = req.getRequestDispatcher("jsp/superadmin.jsp");
		rd.include(req, res);

	}
	
	public void delete(HttpServletRequest req,HttpServletResponse res) {
		String id = req.getParameter("id");
	}
}
