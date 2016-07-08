<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yumi
  Date: 7/8/2016
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dish Information</title>
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

    <h3>Dish List</h3>
    <c:if test="${!empty listDish}">
    <table class="tg">
        <tr>
            <th width="80">Dish ID</th>
            <th width="120">Quantity</th>
            <th width="120">Dish</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>

        </tr>

        <c:forEach items="${listDish}" var="dish">
            <tr>
                <td>${dish.dishId}</td>
                <td>${dish.quantity}</td>
                <td>${dish.dish_name}</td>
                <td>${dish.dish_price}</td>
                <td><a href="<c:url value='/dish/edit/${dish.dishId}' />">Edit</a></td>
                <td><a href="<c:url value='/dish/remove/${dish.dishId}' />">Delete</a></td>
            </tr>
        </c:forEach>
        </c:if>
    </table>
</table>
</body>
</html>
