<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/superadmin.css">
<body>
	<div class="superadmin-container">
		<div class="superadmin-welcome-message">Welcome Super Admin</div>


		<div class="parent-create-options">
			<div class="child-create-option-admin">
				<input class="button" type="submit" value="Create Admin">
			</div>
			<div class="child-create-option-employee">
				<input class="button" type="submit" value="Create Employee">
			</div>
		</div>
		<div class="admin-employee-details">
			<div class="admin-form-div">
				<form action="AdminValidate">
					<label for="option">Choose the details you want to know
						about :</label> <select name="option" class="options">
						<option value="select">Select</option>
						<option value="super admin">Super Admin</option>
						<option value="admin">Admin</option>
						<option value="employee">Employee</option>
					</select> <br> <br>
					<div class="admin-submit-div">
						<input type="submit" value="Submit">
					</div>
				</form>
			</div>



		</div>
		<div class="data">
		<%		
		if(request.getAttribute("select").equals("select")){
			out.print("Select an option");
		}
		else if (!request.getAttribute("select").equals("select")) {
						%>
			<table>
				<thead>
					<tr>
						<th>User Name</th>
						<th>User Email</th>

						<th>Delete</th>

					</tr>
				</thead>
				<tbody>
					<%
						Map<String, String> m = (Map<String, String>) request.getAttribute("data");
						for (Map.Entry<String, String> me : m.entrySet()) {
					%>
					<tr>
						<td><%=me.getKey()%></td>
						<td><%=me.getValue()%></td>
						<td><input type="button" value="Delete"></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>