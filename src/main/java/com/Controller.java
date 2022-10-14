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
			Users u = r.check(name, password);
			if(u!=null) {
				Cookie ck=new Cookie("user_id",Integer.toString(u.getUser_id()));
				Cookie ck1=new Cookie("user_role",u.getRole());
				res.addCookie(ck1);
				res.addCookie(ck);
				
				res1=u.getRole();
				if (res1.equals("admin")) {
					rd = req.getRequestDispatcher("jsp/admin.jsp");
					rd.forward(req, res);
//					res.sendRedirect("jsp/admin.jsp");

				} else if (res1.equals("employee")) {
					rd = req.getRequestDispatcher("jsp/employee.jsp");
					rd.forward(req, res);
//					res.sendRedirect("jsp/employee.jsp");


				} else if (res1.equals("super_admin")) {
					rd = req.getRequestDispatcher("jsp/superadmin.jsp");
					rd.forward(req, res);
//					res.sendRedirect("jsp/superadmin.jsp");

				}
			}
			else {
				Error e1 = new Error();
				req.setAttribute("error", e1.returnHTML());
				rd = req.getRequestDispatcher("index.jsp");
				rd.include(req, res);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

