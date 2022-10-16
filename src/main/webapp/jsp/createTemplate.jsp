<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/createTemplate.css">
<style>
.heading {
	color: rgb(118, 67, 165);
	width: 100%;
	display: flex;
	flex-direction: column;
	text-align: center;
}

.button-div {
	align-self: flex-end;
}
.button{
text-decoration: none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="heading">
			<h3>Create Template</h3>
			<div class="button-div">
				<a class="button" href="admin.jsp">Back</a>
			</div>
			<div class="form-div">
				<form action="../CreateTemplate">
					<div>
						<div class="template-name">
							<label for="">Enter Template name: </label> <input type="text"
								name="template">
						</div>
						<div class="topic-name">
							<div class="topic-input">
								<label for="">Topic name: </label> <input type="text"
									name="topic">
							</div>
							<div class="topic-input">
								<label for="">Topic name: </label> <input type="text"
									name="topic">
							</div>
							<div class="topic-input">
								<label for="">Topic name: </label> <input type="text"
									name="topic">
							</div>
							<div class="topic-input">
								<label for="">Topic name: </label> <input type="text"
									name="topic">
							</div>
							<div class="topic-input">
								<label for="">Topic name: </label> <input type="text"
									name="topic">
							</div>
							<div class="topic-input">
								<label for="">Topic name: </label> <input type="text"
									name="topic">
							</div>
							<div class="topic-input">
								<label for="">Topic name: </label> <input type="text"
									name="topic">
							</div>
						</div>
					</div>
					<input class="button" type="submit" value="submit">
				</form>
			</div>

		</div>
</body>
</html>