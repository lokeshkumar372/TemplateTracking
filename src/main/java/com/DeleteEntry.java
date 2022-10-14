package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/Delete", loadOnStartup = 1)

public class DeleteEntry extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			System.out.println(req.getParameter("id"));
			DataOperations.delete(req.getParameter("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jakarta.servlet.RequestDispatcher rd;
		String role=req.getParameter("role");
		rd = req.getRequestDispatcher("/Validate?option="+role);
		rd.forward(req, res);
	}
}
