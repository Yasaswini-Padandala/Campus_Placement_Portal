<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
String admin =
(String)session.getAttribute("admin");

if(admin == null){

response.sendRedirect("login.jsp");
return;


}
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
      rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    min-height:100vh;
    background:
    linear-gradient(
    135deg,
    #0f172a,
    #1e293b,
    #334155);
}

.navbar{

    width:100%;

    padding:20px 45px;

    display:flex;

    justify-content:space-between;

    align-items:center;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(15px);

    border-bottom:
    1px solid rgba(255,255,255,0.1);

    position:sticky;

    top:0;

    z-index:1000;
}

.navbar h2{

    color:white;

    font-size:28px;

    letter-spacing:1px;
}

.logout-btn{

    text-decoration:none;

    background:
    linear-gradient(
    45deg,
    #ef4444,
    #dc2626);

    color:white;

    padding:12px 24px;

    border-radius:12px;

    font-weight:600;

    transition:0.3s;
}

.logout-btn:hover{

    transform:translateY(-3px);
}

.container{

    width:92%;

    margin:auto;

    padding:35px 0;
}

.welcome-card{

    background:
    rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border-radius:25px;

    padding:40px;

    margin-bottom:35px;

    border:
    1px solid rgba(255,255,255,0.1);
}

.welcome-card h1{

    color:white;

    font-size:36px;

    margin-bottom:12px;
}

.welcome-card p{

    color:#cbd5e1;

    font-size:17px;
}

.stats{

    display:grid;

    grid-template-columns:
    repeat(auto-fit,
    minmax(230px,1fr));

    gap:25px;

    margin-bottom:40px;
}

.stat-card{

    background:
    rgba(255,255,255,0.08);

    backdrop-filter:blur(15px);

    border-radius:20px;

    padding:30px;

    text-align:center;

    border:
    1px solid rgba(255,255,255,0.1);

    transition:0.4s;
}

.stat-card:hover{

    transform:
    translateY(-8px);
}

.stat-card h2{

    font-size:42px;

    color:#60a5fa;

    margin-bottom:10px;
}

.stat-card p{

    color:#cbd5e1;

    font-size:16px;
}

.menu-grid{

    display:grid;

    grid-template-columns:
    repeat(auto-fit,
    minmax(280px,1fr));

    gap:30px;

    margin-bottom:40px;
}

.card{

    background:
    rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border-radius:25px;

    padding:35px;

    text-align:center;

    border:
    1px solid rgba(255,255,255,0.1);

    transition:0.4s;
}

.card:hover{

    transform:
    translateY(-10px)
    scale(1.02);
}

.card h3{

    color:white;

    font-size:24px;

    margin-bottom:15px;
}

.card p{

    color:#cbd5e1;

    line-height:1.8;

    margin-bottom:25px;
}

.card a{

    text-decoration:none;

    display:inline-block;

    background:
    linear-gradient(
    45deg,
    #2563eb,
    #3b82f6);

    color:white;

    padding:12px 28px;

    border-radius:12px;

    font-weight:600;

    transition:0.3s;
}

.card a:hover{

    transform:scale(1.05);
}

.footer{

    text-align:center;

    color:#94a3b8;

    padding:25px;

    border-top:
    1px solid rgba(255,255,255,0.08);
}

</style>

</head>

<body>

<div class="navbar">

<h2>Admin Dashboard</h2>

<a href="login?action=logout"
class="logout-btn">

Logout

</a>

</div>

<div class="container">

<div class="welcome-card">

<h1>🎓 Campus Placement Portal</h1>

<p>

Manage students, companies, jobs and applications
through one powerful dashboard.

</p>

</div>

<div class="stats">

<div class="stat-card">

<h2>${totalStudents}</h2>

<p>Total Students</p>

</div>

<div class="stat-card">

<h2>${totalCompanies}</h2>

<p>Total Companies</p>

</div>

<div class="stat-card">

<h2>${totalJobs}</h2>

<p>Total Jobs</p>

</div>

<div class="stat-card">

<h2>${totalApplications}</h2>

<p>Total Applications</p>

</div>

</div>

<div class="menu-grid">

<div class="card">

<h3>👨‍🎓 Manage Students</h3>

<p>
View, manage and remove student records.
</p>

<a href="viewStudents">

Manage Students

</a>

</div>

<div class="card">

<h3>🏢 Manage Companies</h3>

<p>
Monitor registered companies and their details.
</p>

<a href="viewCompanies">

Manage Companies

</a>

</div>

<div class="card">

<h3>💼 Manage Jobs</h3>

<p>
View all jobs posted by companies.
</p>

<a href="viewJobsAdmin">

Manage Jobs

</a>

</div>

<div class="card">

<h3>📄 Applications</h3>

<p>
Track all student job applications.
</p>

<a href="viewApplications">

View Applications

</a>

</div>

</div>

</div>

<div class="footer">

© 2026 Campus Placement Portal | Admin Dashboard

</div>

</body>
</html>
