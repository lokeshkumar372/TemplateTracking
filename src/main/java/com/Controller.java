package com;

import java.io.IOException;
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

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Repo r = new Repo();
		String res1 = null;
		try {
			res1 = r.check(name, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (res1 != null) {
			Users u = new Users();
			u.setuser_email(name);
			u.setPassword(password);

			req.setAttribute("user", u);
			RequestDispatcher rd = null;
			if (res1.equals("admin")) {
				rd = req.getRequestDispatcher("jsp/admin.jsp");

			} else if (res1.equals("employee")) {
				rd = req.getRequestDispatcher("jsp/employee.jsp");

			} else if (res1.equals("super admin")) {
				rd = req.getRequestDispatcher("jsp/superadmin.jsp");

			} else {
				rd = req.getRequestDispatcher("jsp/error.jsp");
			}
			rd.forward(req, res);
		}
	}

//	@GET
//	@Path("/login")
//	public Response check(@QueryParam("name") String name, @QueryParam("password") String pass) throws SQLException {
//		String role = null;
//		Repo r = new Repo();
//		role = r.check(name, pass);
//		if (role != null) {
//			if (role.equals("employee")) {
//
//			} else if (role.equals("admin")) {
//				
//			}
//			return Response.ok("Your role is : " + role).build();
//		} else {
//			return Response.ok().build();
//		}
//	}

}
