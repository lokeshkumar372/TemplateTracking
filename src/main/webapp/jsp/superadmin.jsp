<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.bean.Users,com.DataOperations,jakarta.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	padding: 0;
	margin: 0;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.superadmin-container>.data {
	text-align: left;
	flex-grow: 1;
	min-width: 80%
}

.display-table {
	width: 100%;
	color: rgb(118, 67, 165);
	border: 1px solid rgb(118, 67, 165);
}

.superadmin-container>.data input {
	background-color: rgb(118, 67, 165);
	border: 0px;
	color: white;
	width: 55px;
	height: 2em;
	border-radius: 2px;
}

.superadmin-welcome-message {
	color: rgb(118, 67, 165);
	font-size: 3rem;
	padding-top: 3rem;
	flex-grow: 1;
}

.superadmin-container {
	display: flex;
	width: 80%;
	height: 80%;
	align-items: center;
	justify-content: center;
	flex-wrap: wrap;
	flex-direction: column;
	border: 2px solid rgb(118, 67, 165);
}

.parent-create-options {
	display: flex;
	justify-content: space-evenly;
	width: 100%;
	padding: 20px;
	flex-grow: 1;
}

.admin-employee-details {
	display: flex;
	flex-grow: 1;
	width: 50%;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.admin-employee-details label {
	color: rgb(118, 67, 165);
	font-size: 1.5rem;
}

.admin-employee-details select {
	color: rgb(118, 67, 165);
	font-size: 1rem;
}

.admin-employee-details form :focus {
	color: rgb(118, 67, 165);
	font-size: 1rem;
}

.admin-submit-div {
	margin-left: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.admin-form-div{
	display: flex;
	justify-content: center;
	align-items: center;
}

.admin-submit-div input {
	background: rgb(118, 67, 165);
	border-radius: 999px;
	box-shadow: #5E5DF0 0 10px 20px -10px;
	box-sizing: border-box;
	color: #FFFFFF;
	cursor: pointer;
	font-family: Inter, Helvetica, "Apple Color Emoji", "Segoe UI Emoji",
		NotoColorEmoji, "Noto Color Emoji", "Segoe UI Symbol", "Android Emoji",
		EmojiSymbols, -apple-system, system-ui, "Segoe UI", Roboto,
		"Helvetica Neue", "Noto Sans", sans-serif;
	font-size: 16px;
	font-weight: 700;
	line-height: 24px;
	opacity: 1;
	outline: 0 solid transparent;
	padding: 8px 18px;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
	width: fit-content;
	word-break: break-word;
	border: 0;
}

.data {
	flex-grow: 7;
}

/* CSS */
.button {
	font-family: "Open Sans", sans-serif;
	font-size: 16px;
	letter-spacing: 2px;
	text-decoration: none;
	text-transform: uppercase;
	color: rgb(118, 67, 165);
	cursor: pointer;
	border: 3px solid;
	padding: 0.25em 0.5em;
	box-shadow: 1px 1px 0px 0px, 2px 2px 0px 0px, 3px 3px 0px 0px, 4px 4px
		0px 0px, 5px 5px 0px 0px;
	position: relative;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
}

.button-54:active {
	box-shadow: 0px 0px 0px 0px;
	top: 5px;
	left: 5px;
}

@media ( min-width : 768px) {
	.button-54 {
		padding: 0.25em 0.75em;
	}
}
</style>
<body>
	<div class="superadmin-container">
		<div class="superadmin-welcome-message">Welcome Super Admin</div>


		<div class="parent-create-options">
			<div class="child-create-option-admin">
				<a class="button" type="submit" value="Create Admin"
					href="jsp/createUser.jsp?role=admin">Create Admin</a>

			</div>
			<div class="child-create-option-employee">
				<a class="button" type="submit" value="Create Employee"
					href="jsp/createUser.jsp?role=employee">Create Employee</a>
			</div><%-- --%>
		</div>
		<div class="admin-employee-details">
			<div class="admin-form-div">
				<form action="Validate">
					<label for="option">Choose the details you want to know
						about :</label> <select name="option" class="options">
						<option value="select">Select</option>
						<option value="super_admin">Super Admin</option>
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
			
			Map<String, String[]> map = request.getParameterMap();
			if (map.get("option") != null) {
			%>
			<table class="display-table">
				<thead>
					<tr>
						<th>User Name</th>
						<th>User Email</th>

						<th>Delete</th>

					</tr>
				</thead>
				<tbody>


					<%
					List<Users> m = (List<Users>) request.getAttribute("data");
					System.out.print(m);

					for (Users me : m) {
						int id = me.getUser_id();
						System.out.println(me.getRole());
					%>
					<tr>
						<td><%=me.getUser_name()%></td>
						<td><%=me.getuser_email()%></td>
						<form action="Delete">
							<input type="hidden" name="id" value=<%=me.getUser_id()%>>
							<input type="hidden" name="role" value=<%=me.getRole()%>>

							<td><input type="submit" value="Delete"></td>
						</form>
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