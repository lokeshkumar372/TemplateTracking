package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.bean.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(value = "/Validate", loadOnStartup = 1)
public class Validate extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		
		String select = req.getParameter("option");
		
//		Map<String, String> m = new HashMap<>();
		List<Users> m = new ArrayList();
		Users u;
		DataOperations r = new DataOperations();
		
		
		
		try {
			ResultSet rs = r.getUsersDetails(select);
			while(rs.next()) {
				//System.out.println("hello");
				u=new Users();
				
				u.setUser_id(rs.getInt(1));
				u.setUser_name(rs.getString(2));
				u.setuser_email(rs.getString(3));
				u.setRole(select);
				u.setPassword("");
				m.add(u);
				//System.out.println("hello");

//				m.put(rs.getString(1), rs.getString(2));
			}
			req.setAttribute("select", select);
			req.setAttribute("data", m);
			
		} catch (SQLException e) {
			System.out.println("Admin Validate: "+e.getMessage());
		}
		
		rd = req.getRequestDispatcher("jsp/superadmin.jsp");
		rd.forward(req, res);
	}
	
	public void delete(HttpServletRequest req,HttpServletResponse res) {
		String id = req.getParameter("id");
	}
}
