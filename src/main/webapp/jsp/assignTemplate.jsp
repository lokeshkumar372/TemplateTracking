<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.bean.Users,com.bean.Template"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/assignTemplate.css">
</head>
<body>

<div class="container">
        <div class="welcome-div">Assign Template</div>
        <div>
  
            <form action="assignTemplate">
                <div  class="assign-div">
                    <div class="selectdiv template-select-div">
                        <h2>Please Select Template</h2>
                        <select name="employee">
                        <option value="select">Select</option>
                        <%
                        List<Users> emp_list=(List<Users>)request.getAttribute("employees");
                        //System.out.println("in jsp "+emp_list);
                        for(Users u:emp_list){
                        	%>
                        	<option value=<%=u.getUser_id() %>><%=u.getUser_name() %>></option>
                        	
                        	<%
                        	
                        }
                        
                        %>
                            
                        </select>
                    </div>
                    <div class="selectdiv employee-select-div">
                        <h2>Please Select Employee</h2>
                        <select name="template">
                            <option value="select">Select</option>
                             <%
                        List<Template> temp_list=(List<Template>)request.getAttribute("templates");
                        for(Template t:temp_list){
                        	%>
                        	<option value=<%=t.getTemplate_id() %>><%=t.getTemplate_name() %></option>
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
        </div>
        
    </div>

</body>
</html>