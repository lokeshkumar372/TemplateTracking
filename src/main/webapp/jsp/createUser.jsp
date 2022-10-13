<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Template Tracking</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="../css/createuser.css">
</head>
<body>
  <div class="container">
  
<div class="left">
    <div class="form_div">
      
      <form action="../Create">
        <div class="form-item item1">Enter User email</div>
        <label class="form-input"> 
          <span class="material-icons">people_alt</span>
          <input class="text_input" style="border:0px; height: 100%;" type=text  placeholder='UserEmail' name="user_email">
        </label>
        <input type="hidden" value=<%=request.getParameter("role")%> name="role">

        <div  class="last"> 
          
          <input class="submitb button" type="submit" value="Submit"> 
        </div>
       
      </form>
    </div>
</html>