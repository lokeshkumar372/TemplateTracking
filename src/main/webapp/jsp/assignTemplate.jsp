<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.bean.Users,com.bean.Template"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.success {
	color: green;
}

body {
	padding: 0;
	margin: 0;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	color: rgb(118, 67, 165);
}

.container {
	height: 70vh;
	width: 70vw;
	border: 2px solid rgb(118, 67, 165);
}

.welcome-div {
	height: 10vh;
	border: 1px solid rgb(118, 67, 165);
	display: flex;
	justify-content: center;
	align-items: center;
	color: rgb(118, 67, 165);
	font-size: 2em;
}

.template-name {
	height: 15vh;
	display: flex;
	justify-content: center;
	align-items: center;
	border: 1px solid rgb(118, 67, 165);
	color: rgb(118, 67, 165);
	font-size: 1.25em;
}

.form-submit {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 9vh;
}

.button {
	background: #5E5DF0;
	border-radius: 999px;
	box-shadow: #5E5DF0 0 10px 20px -10px;
	box-sizing: border-box;
	color: #FFFFFF;
	cursor: pointer;
	/* font-family: Inter,Helvetica,"Apple Color Emoji","Segoe UI Emoji",NotoColorEmoji,"Noto Color Emoji","Segoe UI Symbol","Android Emoji",EmojiSymbols,-apple-system,system-ui,"Segoe UI",Roboto,"Helvetica Neue","Noto Sans",sans-serif; */
	font-size: 16px;
	/* font-weight: 700; */
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
	padding: 5px 30px 5px 30px;
}

.button:active {
	transform: scale(0.8);
}

.assign-div {
	height: 45vh;
	display: flex;
	flex-direction: row;
}

.selectdiv {
	display: flex;
	align-items: center;
	justify-content: center;
	width: 45vw;
	flex-direction: column;
	color: rgb(118, 67, 165);
}

.selectdiv select {
	color: rgb(118, 67, 165);
	width: 15vw;
	height: 3vh;
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
a{
text-decoration:none;
}
</style>
</head>
<body>

	<div class="container">
		<div class="heading">
			<h3>Assign Template</h3>
			<div class="button-div">
				<a class="button" href="jsp/admin.jsp">Back</a>
			</div>
			<div>

				<form action="assignTemplate">
					<div class="assign-div">
						<div class="selectdiv template-select-div">
							<div>Please Select Employee</div>
							<select name="employee">
								<option value="select">Select</option>
								<%
								List<Users> emp_list = (List<Users>) request.getAttribute("employees");
								for (Users u : emp_list) {
								%>
								<option value=<%=u.getUser_id()%>><%=u.getUser_name()%></option>

								<%
								}
								%>

							</select>
						</div>
						<div class="selectdiv employee-select-div">
							<div>Please Select Template</div>
							<select name="template">
								<option value="select">Select</option>
								<%
								List<Template> temp_list = (List<Template>) request.getAttribute("templates");
								for (Template t : temp_list) {
								%>
								<option value=<%=t.getTemplate_id()%>><%=t.getTemplate_name()%></option>
								<%
								}
								%>
							</select>
						</div>
					</div>
					<div class="form-submit">
						<input class="button" type="submit" name="">
					</div>
				</form>
				<div><% if(request.getAttribute("error") != null)
        	out.println(request.getAttribute("error"));
        	%></div>
			</div>
		</div>
		
</body>
</html>