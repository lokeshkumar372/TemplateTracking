package com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bean.StatusTable;
import com.bean.Template;
import com.bean.Topic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/Status" , loadOnStartup = 1)
public class EmployeeToStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		int template_id=Integer.parseInt(req.getParameter("template_id"));
		List<Topic> topic=null;
		Map<Integer,StatusTable> st=null;
		try {
			topic=DataOperations.getTopicByTemplateId(template_id);
			st=DataOperations.getStatusByTemplateIdAndUserId(user_id, template_id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		req.setAttribute("topics", topic);
		req.setAttribute("status", st);
		RequestDispatcher rd=req.getRequestDispatcher("jsp/status.jsp");
		rd.forward(req, resp);
		
	}

}
