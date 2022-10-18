<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.bean.Users,com.bean.Template"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
.display-table {
	text-align: left;
	flex-grow: 1;
	width: 100%;
	border: 1px solid rgb(118, 67, 165);
}

body {
	color: rgb(118, 67, 165);
	padding: 0;
	margin: 0;
	display: flex;
	align-items: center;
}

.container {
	margin: 7px auto;
	width: 70%;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

a {
	color: rgb(118, 67, 165);
	text-decoration: none;
}

a:hover {
	color: red;
}

a:visited {
	color: rgb(118, 67, 165);
}

.heading {
	width: 100%;
	display: flex;
	flex-direction: column;
	text-align: center;
}

.button-div {
	align-self: flex-end;
}
tr{
padding:4px;
}
td{
padding:4px
}
ul{
padding:0px;
width :100%;
}
li{
width:100%;
display: flex;
justify-content: space-between;
}
</style>
</head>
<body>
	<div class="container">
		<div class="heading">
			<h3>Employee Details</h3>
			<div class="button-div">
				<a class="button" href="jsp/admin.jsp">Back</a>
			</div>
			<table class="display-table">
				<thead>
					<tr>
						<th>User Name</th>
						<th>User Email</th>
						<th>Template assigned</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Users> list = new ArrayList();
					Map<Integer, Set<Template>> map = new HashMap();
					list = (List<Users>) request.getAttribute("employeeDetails");
					map = (Map<Integer, Set<Template>>) request.getAttribute("employeeTemplateMap");
					for (Users u : list) {
					%>
					<tr>
						<td><%=u.getUser_name()%></td>
						<td><%=u.getuser_email()%></td>
						<td>
							<ul>
								<%
								Set<Template> set = map.getOrDefault(u.getUser_id(), null);

								if (set != null) {
									Iterator<Template> it = set.iterator();
									while (it.hasNext()) {
										Template t = it.next();
								%>
								<li><a
									href=<%="Status?user_id=" + u.getUser_id() + "&template_id=" + t.getTemplate_id()%>><%=t.getTemplate_name()%></a>
									<a
									href=<%="DeleteAssignedTemplate?user_id=" + u.getUser_id() + "&template_id=" + t.getTemplate_id()%>>delete</a>
									</li>
								<%
								}
								} else {
								out.println("no Template Assigned");
								}
								%>
							</ul>
						</td>

					</tr>

					<%
					}
					%>
				</tbody>

			</table>
			 
		</div>
		<div><% if(request.getAttribute("error") != null)
        	out.println(request.getAttribute("error"));
        	%></div>
</body>
</html>