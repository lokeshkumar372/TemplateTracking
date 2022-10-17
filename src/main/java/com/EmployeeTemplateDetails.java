package com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bean.Template;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/EmployeeTemplateDetails", loadOnStartup = 1)
public class EmployeeTemplateDetails extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int user_id = (int) session.getAttribute("user_id");
		try {
			List<Template> templates = DataOperations.getAssignedTemplatesByUserId(user_id);
			req.setAttribute("templates", templates);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/employee.jsp");
			rd.include(req, res);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
