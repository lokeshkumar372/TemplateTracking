package com;

import java.io.IOException;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bean.Template;
import com.bean.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/DisplayUser", loadOnStartup = 1)

public class DisplayUsers extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Users> list = new ArrayList();
		Map<Integer, Set<Template>> map = new HashMap();
		DataOperations r = new DataOperations();

		try {
			list = r.getUsersDetails("employee");
			map = r.EmployeeIdMapTemplates();
			req.setAttribute("employeeDetails", list);
			req.setAttribute("employeeTemplateMap", map);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/display_employee.jsp");
			rd.forward(req, resp);

		} catch (SQLException e) {
			System.out.println("Display Users: " + e.getMessage());
		}

	}

}
