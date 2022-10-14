package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/SuccessToSuperAdmin", loadOnStartup = 1)
public class SuccessToSuperAdmin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		jakarta.servlet.RequestDispatcher rd=req.getRequestDispatcher("jsp/superadmin.jsp");
	rd.forward(req, res);
	}
}

