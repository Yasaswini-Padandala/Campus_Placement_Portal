<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Placement Portal - Login</title>

<style>

/* RESET */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

html, body{
    height:100%;
}

body{
    min-height:100vh;
    display:flex;
    flex-direction:column;
    background:linear-gradient(135deg,#0f172a,#1e293b,#334155);
}

/* HEADER */
.top-header{
    background:linear-gradient(135deg,#1f2937,#2563eb);
    color:white;
    text-align:center;
    padding:18px;
    font-size:20px;
    font-weight:bold;
}

/* CENTER WRAPPER */
.page-wrapper{
    flex:1;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:25px;
}

/* LOGIN BOX */
.container{
    width:450px;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(20px);
    border:1px solid rgba(255,255,255,0.1);
    padding:40px;
    border-radius:25px;
    box-shadow:0 15px 40px rgba(0,0,0,0.35);
}

/* TITLE */
h1{
    text-align:center;
    margin-bottom:25px;
    color:white;
    font-size:32px;
}

/* INPUTS */
.input-group{
    margin-bottom:18px;
}

label{
    display:block;
    margin-bottom:8px;
    color:#e2e8f0;
    font-weight:600;
}

input, select{
    width:100%;
    padding:14px;
    border-radius:12px;
    border:1px solid rgba(255,255,255,0.15);
    background:rgba(255,255,255,0.08);
    color:white;
    outline:none;
}

input::placeholder{
    color:#cbd5e1;
}

select option{
    color:black;
}

/* FOCUS */
input:focus, select:focus{
    border-color:#60a5fa;
    box-shadow:0 0 12px rgba(96,165,250,0.4);
}

/* BUTTON */
button{
    width:100%;
    padding:15px;
    border:none;
    border-radius:12px;
    background:linear-gradient(45deg,#2563eb,#60a5fa);
    color:white;
    font-size:16px;
    font-weight:600;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    transform:translateY(-3px);
}

/* MESSAGES */
.success{
    background:rgba(34,197,94,0.15);
    color:#86efac;
    padding:10px;
    border-radius:10px;
    text-align:center;
    margin-bottom:10px;
}

.error{
    background:rgba(239,68,68,0.15);
    color:#fca5a5;
    padding:10px;
    border-radius:10px;
    text-align:center;
    margin-bottom:10px;
}

/* LINK */
.register-link{
    text-align:center;
    margin-top:15px;
    color:#cbd5e1;
}

.register-link a{
    text-decoration:none;
    color:#60a5fa;
    font-weight:600;
}

.register-link a:hover{
    color:white;
}

/* FOOTER */
.footer{
    background:#111827;
    color:white;
    text-align:center;
    padding:12px;
    font-size:14px;
    margin-top:auto;
}

</style>

</head>

<body>

<div class="top-header">
    Campus Placement Portal Management System
</div>

<div class="page-wrapper">

<div class="container">

<h1>Login</h1>

<%
String success = (String)request.getAttribute("success");
String error = (String)request.getAttribute("error");

if(success != null){
%>
<div class="success"><%=success %></div>
<% } 

if(error != null){
%>
<div class="error"><%=error %></div>
<% } %>

<form action="login" method="post">

<div class="input-group">
<label>Login As</label>
<select name="role">
<option value="student">Student</option>
<option value="company">Company</option>
<option value="admin">Admin</option>
</select>
</div>

<div class="input-group">
<label>Email</label>
<input type="email" name="email" required>
</div>

<div class="input-group">
<label>Password</label>
<input type="password" name="password" required>
</div>

<button type="submit">Login</button>

</form>

<div class="register-link">
Don't have an account?
<a href="register.jsp">Register Here</a>
</div>

</div>

</div>

<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>

</body>
</html>