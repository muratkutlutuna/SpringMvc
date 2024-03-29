<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> <!-- jstl -->
<!--jstl-- jsp icinde daha az java kodu yazmamizi saglayan bir yapi -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Student-project</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">

</head>

<body>
    <div class="container">
        <h2>Students</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Grade</th>
                <th>CreateDate</th>
            </tr>

            <c:forEach items="${studentList}" var="student" varStatus="status">

                <!-- create an "update" link with student id -->
                <c:url var="updateLink" value="/students/update">
                    <c:param name="id" value="${student.id}" />
                </c:url>

                <!-- create an "delete" link with Student id -->
                <c:url var="deleteLink" value="/students/delete">
                    <c:param name="id" value="${student.id}" />
                </c:url>

                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.grade}</td>
                    <td>${student.createDate}</td>
                    <td>
                        <!-- show the links -->

                        <a class="update" href="${updateLink}">Update</a>
                        <a class="delete" href="${pageContext.request.contextPath}/students/delete/${student.id}">Delete</a>
                        <!-- <a class="delete" href="${deleteLink}"> Delete</a>-->
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p><a class="normal" href="${pageContext.request.contextPath}/students/new">Add Student</a>
    </div>
</body>
</html>