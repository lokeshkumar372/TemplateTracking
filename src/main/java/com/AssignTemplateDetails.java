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
public class AssignTemplateDetails extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> ename = new ArrayList();
		Users u = null;
		try {
			ename = DataOperations.getUsersDetails("employee");
			req.setAttribute("employees", ename);
			req.setAttribute("templates", DataOperations.getAllTemplate());
			RequestDispatcher rd = req.getRequestDispatcher("jsp/assignTemplate.jsp");
			rd.include(req, resp);

		} catch (SQLException e) {
			System.out.println("Assigned Template" + e.getMessage());
		}
	}
}
