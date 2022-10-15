<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.bean.*"%>
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
.container{
    margin:7px auto;
    width: 70%;
    display: flex;
    justify-content: center;
	align-items: center;
    flex-direction: column;
}
a{
    color: rgb(118, 67, 165);
text-decoration: none;
}
a:hover {
	color:red;
}
a:visited {
	    color: rgb(118, 67, 165);
	
}
.heading{
width:100%;
display: flex;
flex-direction: column;
}
.button-div{
align-self: flex-end;
}

    </style>

</head>
<body>
    <div class="container">
        <div class="heading"><h3>Status Page</h3> 
        <div class="button-div">
        <a class="button" href="DisplayUser">Back</a>
        </div>
        </div>
        <table class="display-table">
            <thead>
                <tr>
                    <th>Topic Name</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <%
            List<Topic> topic=(List<Topic>)request.getAttribute("topics");
    		Map<Integer,StatusTable> st=(Map<Integer,StatusTable>)request.getAttribute("status");
            for(Topic t:topic){
            	StatusTable obj=st.get(t.getTopic_id());
            	String status=obj.getStatus();
            	%>
            	<tr id=<%=obj.getStatus_id() %>>
                    <td><%=t.getTopic_name() %></td>
                    <td><%=status %></td>
                </tr>
            	<%
            }
            %>
            
                
            </tbody>
        </table>
    </div>
    
</body>
</html>