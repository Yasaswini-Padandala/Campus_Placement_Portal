<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Placement Portal - Register</title>

<style>

/* RESET */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

/* PAGE STRUCTURE */
html, body{
    height:100%;
}

body{
    min-height:100vh;
    display:flex;
    flex-direction:column;
    background:linear-gradient(135deg,#0f172a,#1e293b,#334155);
}

/* TOP HEADER */
.top-header{
    background:linear-gradient(135deg,#1f2937,#2563eb);
    color:white;
    text-align:center;
    padding:18px;
    font-size:20px;
    font-weight:bold;
}

/* MAIN CONTENT WRAPPER */
.page-wrapper{
    flex:1;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:30px;
}

/* FORM BOX */
.container{
    width:80%;
    max-width:700px;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(20px);
    border-radius:25px;
    padding:40px;
    border:1px solid rgba(255,255,255,0.1);
    box-shadow:0 15px 35px rgba(0,0,0,0.35);
}

/* TITLE */
h1{
    text-align:center;
    color:white;
    margin-bottom:25px;
    font-size:34px;
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

input, select, textarea{
    width:100%;
    padding:14px;
    border-radius:12px;
    border:1px solid rgba(255,255,255,0.15);
    background:rgba(255,255,255,0.08);
    color:white;
    outline:none;
}

input::placeholder, textarea::placeholder{
    color:#cbd5e1;
}

textarea{
    min-height:100px;
    resize:vertical;
}

/* FOCUS */
input:focus, select:focus, textarea:focus{
    border-color:#60a5fa;
    box-shadow:0 0 10px rgba(96,165,250,0.4);
}

/* BUTTON */
button{
    width:100%;
    padding:15px;
    border:none;
    border-radius:12px;
    cursor:pointer;
    font-size:16px;
    font-weight:600;
    color:white;
    background:linear-gradient(45deg,#2563eb,#60a5fa);
    transition:0.3s;
}

button:hover{
    transform:translateY(-2px);
}

/* MESSAGES */
.success{
    background:rgba(34,197,94,0.15);
    color:#86efac;
    padding:10px;
    border-radius:8px;
    margin-bottom:10px;
    text-align:center;
}

.error{
    background:rgba(239,68,68,0.15);
    color:#fca5a5;
    padding:10px;
    border-radius:8px;
    margin-bottom:10px;
    text-align:center;
}

/* LOGIN LINK */
.login-link{
    text-align:center;
    margin-top:15px;
    color:#cbd5e1;
}

.login-link a{
    color:#60a5fa;
    text-decoration:none;
    font-weight:600;
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

<script>
function toggleFields(){
    let role = document.getElementById("role").value;

    document.getElementById("studentFields").style.display =
        (role === "student") ? "block" : "none";

    document.getElementById("companyFields").style.display =
        (role === "company") ? "block" : "none";
}

window.onload = toggleFields;
</script>

</head>

<body>

<div class="top-header">
    Campus Placement Portal Management System
</div>

<div class="page-wrapper">

<div class="container">

<h1>Create Account</h1>

<%
String success = (String)request.getAttribute("success");
String error = (String)request.getAttribute("error");

if(success != null){
%>
<div class="success"><%=success%></div>
<% } 

if(error != null){
%>
<div class="error"><%=error%></div>
<% } %>

<form action="register" method="post">

<div class="input-group">
<label>Register As</label>
<select id="role" name="role" onchange="toggleFields()">
<option value="student">Student</option>
<option value="company">Company</option>
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

<div id="studentFields">

<div class="input-group">
<label>Full Name</label>
<input type="text" name="name">
</div>

<div class="input-group">
<label>Phone</label>
<input type="text" name="phone">
</div>

<div class="input-group">
<label>CGPA</label>
<input type="number" step="0.01" name="cgpa">
</div>

<div class="input-group">
<label>Skills</label>
<textarea name="skills"></textarea>
</div>

</div>
<div id="companyFields">

<div class="input-group">
<label>Company Name</label>
<input type="text" name="companyName">
</div>

<div class="input-group">
<label>Location</label>
<input type="text" name="location">
</div>

</div>

<button type="submit">Register</button>

</form>

<div class="login-link">
Already have an account?
<a href="login.jsp">Login Here</a>
</div>

</div>

</div>

<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>

</body>
</html>