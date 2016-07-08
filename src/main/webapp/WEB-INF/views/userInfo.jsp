<%--
  Created by IntelliJ IDEA.
  User: Yumi
  Date: 7/7/2016
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
<style type="text/css">
    .tg {
        border-collapse: collapse;
        border-spacing: 0;
        border-color: #ccc;
    }

    .tg td {
        font-family: Arial, sans-serif;
        font-size: 14px;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #fff;
    }

    .tg th {
        font-family: Arial, sans-serif;
        font-size: 14px;
        font-weight: normal;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #f0f0f0;
    }

    .tg .tg-4eph {
        background-color: #f9f9f9
    }
</style>
<table>

    <h3>User List</h3>
    <c:if test="${!empty listUser}">
    <table class="tg">
        <tr>
            <th width="80">User ID</th>
            <th width="120">First Name</th>
            <th width="120">Last Name</th>
            <th width="120">Role</th>
            <th width="120">Phone</th>
            <th width="120">Email</th>
            <th width="120">Address</th>
            <th width="120">Username</th>
            <th width="120">Password</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>

        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.role}</td>
                <td>${user.phone}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td><a href="<c:url value='/user/edit/${user.userId}' />">Edit</a></td>
                <td><a href="<c:url value='/user/remove/${user.userId}' />">Delete</a></td>
            </tr>
        </c:forEach>
        </c:if>
    </table>
</table>
</body>
</html>
