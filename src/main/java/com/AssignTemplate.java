package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/assignTemplate", loadOnStartup = 1)
public class AssignTemplate extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String template_id=req.getParameter("template");
		String employee_id=req.getParameter("employee");
		if(!template_id.equals("select") && !employee_id.equals("select")) {
			int temp_id=Integer.parseInt(template_id);
			int emp_id=Integer.parseInt(employee_id);
			
			List<Integer> list=new ArrayList();
			try {
				list=DataOperations.getTopicIdsByTemplate(temp_id);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			try {
				DataOperations.createStatus(temp_id,emp_id,list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			PrintWriter out=resp.getWriter();
			out.println("<div style='color:green;'>Template Assigned Successfully</div> ");
			RequestDispatcher rd=req.getRequestDispatcher("assignTemplateDetails");
			rd.include(req, resp);
		}
		else {
			
			PrintWriter out=resp.getWriter();
            out.println("<div style=\"color:red;\">Sorry, Please select both options</div> ");
            RequestDispatcher rd=req.getRequestDispatcher("assignTemplateDetails");
            rd.include(req, resp);
		}

	}

}
