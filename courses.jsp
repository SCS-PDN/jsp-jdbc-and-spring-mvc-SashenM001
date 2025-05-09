<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.university.model.Course" %>

<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
%>

<html>
<head><title>Courses</title></head>
<body>
    <h2>Available Courses</h2>

    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Instructor</th><th>Credits</th><th>Action</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseId}</td>
                <td>${course.name}</td>
                <td>${course.instructor}</td>
                <td>${course.credits}</td>
                <td>
                    <form action="register/${course.courseId}" method="post">
                        <input type="submit" value="Register"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
