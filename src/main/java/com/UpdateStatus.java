package com;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/UpdateStatus" , loadOnStartup = 1)

public class UpdateStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status_id=Integer.parseInt(req.getParameter("status_id"));
		String status=req.getParameter("status");
		status=status.replace('_', ' ');
		int template_id=Integer.parseInt(req.getParameter("template_id"));
		HttpSession session=req.getSession();  
        System.out.println("user_id : "+session.getAttribute("user_id")+", template_id : "+template_id+" status : "+status);
		try {
			if(DataOperations.updateStatusByStatusId(status_id,status)) {
				RequestDispatcher rd=req.getRequestDispatcher("GetTopicsByTemplate?template_id="+template_id);
				rd.include(req, resp);
			}
		} catch (SQLException | ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
