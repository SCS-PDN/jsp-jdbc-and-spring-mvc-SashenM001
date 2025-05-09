<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        Email: <input type="text" name="email" required /><br><br>
        Password: <input type="password" name="password" required /><br><br>
        <input type="submit" value="Login" />
    </form>

    <p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
</body>
</html>
