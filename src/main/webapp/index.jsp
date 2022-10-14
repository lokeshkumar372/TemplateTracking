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
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="container">
  
<div class="left">
    <div class="form_div">
      <form action="Controller">
        <div class="form-item item1">Get Started</div>
        <label class="form-input"> 
          <span class="material-icons">people_alt</span>
          <input class="text_input" style="border:0px; height: 100%;" type= text  placeholder='Username' name="name">
        </label>
       <label class="form-input ">
        <span class="material-icons">lock</span>
        <input class="text_input" style="border:0px; height: 100%;" type="password"  placeholder="Password" name="password">
       </label>

        <div  class="last"> 
          <a  href="#">Forget Password?</a>
          <input class="button" type="submit" value="SIGN IN"> 
        </div>
        <% if(request.getAttribute("error") != null)
        	out.println(request.getAttribute("error"));
        	%>
      </form>
    </div>
</html>