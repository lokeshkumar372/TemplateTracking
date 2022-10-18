package com;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/DeleteAssignedTemplate", loadOnStartup = 1)

public class DeleteAssignedTemplate extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		int template_id=Integer.parseInt(req.getParameter("template_id"));
		RequestDispatcher rd = null;
		try {
			DataOperations.deleteAssignTemplate(user_id,template_id);
		} catch (Exception e) {
			req.setAttribute("error", Error.returnAlreadyDeleted());
		} 
		rd = req.getRequestDispatcher("DisplayUser");
		rd.include(req, res);
		
	}

}
