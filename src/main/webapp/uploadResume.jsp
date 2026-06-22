<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Resume</title>

<style>

body{
    font-family:Segoe UI;
    background:#f4f6f9;
}

.container{
    width:500px;
    margin:100px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 5px 15px rgba(0,0,0,0.1);
}

input{
    width:100%;
    padding:12px;
    margin-top:10px;
    border:1px solid #ddd;
    border-radius:6px;
}

button{
    width:100%;
    padding:12px;
    margin-top:15px;
    background:#2563eb;
    color:white;
    border:none;
    border-radius:6px;
}
html, body {
    height: 100%;
    margin: 0;
    display: flex;
    flex-direction: column;
}

/* This makes content take full height */
body {
    min-height: 100vh;
}

/* Main page wrapper (IMPORTANT) */
.container {
    flex: 1;
}

/* Top title bar */
.top-header {
    background: linear-gradient(135deg, #1f2937, #2563eb);
    color: white;
    text-align: center;
    padding: 18px;
    font-size: 20px;
    font-weight: bold;
    letter-spacing: 1px;
}

/* Sticky footer */
.footer {
    background: #111827;
    color: white;
    text-align: center;
    padding: 12px;
    margin-top: auto;
    font-size: 14px;
}

</style>

</head>
<body>

<div class="top-header">
    Campus Placement Portal Management System
</div>
<div class="container">

<h2>Upload Resume Link</h2>

<form action="uploadResume"
      method="post">

<input type="url"
       name="resumeLink"
       placeholder="Paste Google Drive Resume Link"
       required>

<button type="submit">

Save Resume

</button>

</form>

</div>
<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>
</body>
</html>