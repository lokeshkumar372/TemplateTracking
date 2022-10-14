package com;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(value = "/CreateTemplate" , loadOnStartup = 1)
public class CreateTemplate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] topics = req.getParameterValues("topic");
		String template_name = req.getParameter("template");
		
		try {
			DataOperations.createTemplate(template_name);
			int template_id = DataOperations.getTemplateId(template_name);
			DataOperations.createTopics(topics, template_id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		resp.sendRedirect("jsp/admin.jsp");
		
	}
}
