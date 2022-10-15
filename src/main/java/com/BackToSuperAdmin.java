package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/BackToSuperAdmin", loadOnStartup = 1)

public class BackToSuperAdmin extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		jakarta.servlet.RequestDispatcher rd=req.getRequestDispatcher("jsp/superadmin.jsp");
		rd.forward(req, res);
	}
}