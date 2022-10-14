package com;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class AssignTemplate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataOperations d = new DataOperations();
		List<String> email = new ArrayList<>();
		try {
			ResultSet res = d.getUsersDetails("employee");
			while(res.next()) {
				 email.add(res.getString(3));
			}
			
		} catch (SQLException e) {
			System.out.println("Assigned Template"+e.getMessage());
		}
	}
}
