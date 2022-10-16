<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.bean.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Template Tracking</title>
   <style>
   .container{
    height: 90vh;
    width: 90vw;
    border: 1px solid black;
}
body{
    margin: 0;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}
.welcome-employee{
    display: flex;
    justify-content: center;
    align-items: center;
    height: 10vh;
    font-size: 1.5rem;
    border-bottom: 1px solid black;
}
.view-template{
    height: 15vh;
    display: flex;
    justify-content: center;
    align-items: center;
}
.table-div{
    display: flex;
    justify-content: center;
    align-items: center;
    height: 64.9vh;
}
.table-display-div{
    overflow-y: auto;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 70vw;
    overflow-y: auto;
  }
  td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }
  tr:nth-child(even) {
    background-color: #dddddd;
  }
  .table-display-div{
    height: 40vh;
  }
  .submit-div{
    display: flex;
    align-items: center;
    justify-content: center;
    height: 10vh;
  }
   </style>
</head>
<body>
    <div class="container">
        <div class="welcome-employee">
            Welcome Employee
        </div>
        <div class="view-template">
            <form action="GetTopicsByTemplate">
                <select name="template_id">
                    <option value="select">Select</option>
                    <%
                    List<Template> templates=(List<Template>)request.getAttribute("templates");
                    for(Template t:templates){
                    %>
                        <option value=<%=t.getTemplate_id()%>><%=t.getTemplate_name() %></option>
                     <%
                    }
                     %>
                        
                </select>
                <input type="submit" value="submit">
            </form>
        </div>
        <div class="table-div">
        <%
        List<Topic> topic=new ArrayList();
		Map<Integer,StatusTable> map=null;
        for (Enumeration enumeration = request.getAttributeNames(); enumeration.hasMoreElements(); ) {
           	String name= (String)enumeration.nextElement();
           	if(name.equals("topics")){
           		topic=(List<Topic>)request.getAttribute("topics");
           	}
           	else if(name.equals("status")){
           		map=(Map<Integer,StatusTable>)request.getAttribute("status");
           	}
           
          }
        %>
                <form action="">
                    <div class="table-display-div">
                        <table>
                            <tr>
                              <th>Topic Name: </th>
                              <th>Status</th>
                            </tr>
                            <% 
                           
                            for(Topic t:topic){
                            	String status=map.get(t.getTopic_id()).getStatus();
                            	int status_id=map.get(t.getTopic_id()).getStatus_id();
                            	int template_id=map.get(t.getTopic_id()).getTemplate_id();
                            %>
                            <tr id=<%=t.getTopic_id() %>>
                              <td><%=t.getTopic_name() %></td>
                              <td>
                                <select name=<%=status_id %> onchange="location = this.value;">
                                        <option value=<%="UpdateStatus?template_id="+template_id+"&status_id="+status_id+"&status=started" %> <%=status.equals("started")?"selected":""%>>On it</option>
                                        <option value=<%="UpdateStatus?template_id="+template_id+"&status_id="+status_id+"&status=not_started"%> <%=status.equals("not started")?"selected":""%>>Not yet started</option>
                                        <option value=<%="UpdateStatus?template_id="+template_id+"&status_id="+status_id+"&status=done" %> <%=status.equals("done")?"selected":""%>>Completed</option>
                                </select>
                              </td>
                            </tr>
                            <%
                            }
                            %>
                            
                          </table>
                    </div>
                    <%--
                    		<div class="submit-div">
                    <input type="submit">
                </div>
                    --%>
                    
                </form>
                <% %>
        </div>
    </div>
</body>
</html>