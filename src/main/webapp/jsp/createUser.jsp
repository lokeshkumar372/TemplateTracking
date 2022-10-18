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
<style>
*{
    margin:0;
    padding: 0;
    font-family:  sans-serif;
}

.container{
    min-width:100vw;
    min-height:100vh;
    display:flex;
    flex-wrap: wrap-reverse;
}
.container>*{
    flex: 1 1 280px;
}
.left .material-icons{
    font-size: 1em;
    outline-offset: 0ch;
    margin: auto;
}

.left{
color: rgb(118, 67, 165);
display:flex;
align-items: center;
}

.form_div{
    width: 1%;
    border: 2px solid  rgb(118, 67, 165);
    padding: 5rem;
}

.left .form_div{
    flex:0.2 1 auto;
    /* width:60%; */
    min-height:300px;
    margin:auto;
}
.left .form_div form>*{
    margin: 8px;
}

.form_div .item1{
    font-family: 'Rubik', sans-serif;
     font-weight: 100;
      font-size: 2em;
}
.left .form_div .form-input{
border-bottom: 1.5px solid rgb(118, 67, 165);
color: rgb(118, 67, 165);
display:flex;
align-items: flex-end;
margin-bottom:10px;

} 
.left .form_div .form-input>.text_input{
    margin-left: 4px;
    flex: 1 1;
    min-height: 3em;
}
.left .form_div .form-item{
    padding: 10px 0 25px 0;
}
.text_input::placeholder{
    color: rgb(118, 67, 165);
}
.text_input:focus{
outline: 0px;
color: rgb(118, 67, 165);
}

.last{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
}
.last>*{
    margin: 18px 0px;
}
.last a{
    text-decoration: none;
    color: unset;
}

/* .button{
    background-color: rgb(5, 227, 209);
    color: whitesmoke;
    padding: 10px 70px;
    border: 0ch;
    border-radius: 18px;
    box-shadow: 4px 4px 4px  rgb(127, 198, 192);
}

.button:active{
    transform: scale(0.8);
} */

.right{  
    background-image: linear-gradient(to top right,rgb(98, 54, 175) 60%,rgb(178, 115, 237) 100%);
    color: white;
}
.right-container{
    height: 100%;
   display: flex;
    flex-direction: column;
}

.right .right-container .right_header{
margin: auto;
display: flex;
align-items: center;
flex-direction: column;


}

.right .right-container .right_header p{
    width:55%;
}
.bi{
    font-size: 4em;
}
.logo_container-item{
    
    text-align: center;
  margin:30px;
}
.right .right_footor{
    display: flex;
    justify-content: center;
}
.right_footor>*{
    white-space: nowrap;
    font-family:Verdana, sans-serif;
    letter-spacing:0.2mm;
    font-size: small;
    text-align: center;
}
.right_footor .right_footor_right{
    border:1px ;
    border-color: transparent white transparent transparent;
    border-style: solid;
    padding:0px 10%  6px 0px;
}

.right_footor .right_footor_left{
    padding:0px 0px 6px 10%;
    border:1px ;
    border-color: transparent transparent transparent white;
    border-style: solid;
}

@media screen and (max-height:430px) {
    .container{
        flex-direction: column-reverse;
        margin: 5px;
    }
    .container>*{
        min-height: 100vh;
        flex-basis: 100%;
    }
    
    
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
.button:active{
    transform: scale(0.8);
} 
</style>
</head>
<body>
  <div class="container">
  
<div class="left">
    <div class="form_div">
    <div style='position: relative; left: 330px; bottom:50px; '><a href = "jsp/superadmin.jsp" style='text-decoration: none;' >Back</a></div>
      
      <form action="http://localhost:8081/TemplateTrackingLokesh/Create">
        <div class="form-item item1">Enter User email</div>
        <label class="form-input"> 
          <span class="material-icons">people_alt</span>
          <input class="text_input" style="border:0px; height: 100%;" type=text  placeholder='UserEmail' name="user_email">
        </label>
        <input type="hidden" value=<%=request.getParameter("role")%> name="role">

        <div  class="last"> 
          
          <input class="submitb button" type="submit" value="Submit"> 
        </div>
        <% if(request.getAttribute("error") != null)
        	out.println(request.getAttribute("error"));
        	%>
      </form>
      
    </div>
</html>