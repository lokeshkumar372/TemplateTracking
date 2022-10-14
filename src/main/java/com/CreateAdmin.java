package com;

import java.io.IOException;
import java.util.function.Supplier;
import com.bean.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class CreateAdmin extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		boolean ans = false;
		String email = req.getParameter("email");
		
		String Username = email.substring(0,email.indexOf("@"));
		
		Users u = new Users();
		Supplier<Integer> s = ()-> ((int)Math.random());
		u.setPassword(Username+s.get());
		u.setuser_email(email);
		u.setUser_name(Username);
		u.setRole("admin");
		DataOperations r = new DataOperations();
//		try {
//		 ans = r.createAdmin(u);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		if(ans) {
			rd = req.getRequestDispatcher("jsp/success.jsp");
			rd.forward(req, res);
		}else {
			rd = req.getRequestDispatcher("jsp/error.jsp");
			rd.forward(req, res);
		}
	}

}
