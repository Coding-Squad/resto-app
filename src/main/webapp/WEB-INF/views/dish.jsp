<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Yumi
  Date: 7/8/2016
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dish</title>
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

    <h1>Dish Cheka</h1>
</head>
<body>
<c:url var="addAction" value="/dish/add"></c:url>

<form:form action="${addAction}" commandName="dish">

    <%-- private int dishId;
        private int quantity;
        private String dish_name;
        private int dish_price;
        private Timestamp createdAt;
        private Timestamp updatedAt;
        private Timestamp deletedAt; --%>
    <table>
        <form:hidden path="dishId"/>
        <tr>
            <td><form:label path="quantity">
                <spring:message text="Quantity"/>
            </form:label></td>
            <td><form:input path="quantity"/></td>
        </tr>

        <tr>
            <td><form:label path="dish_name">
                <spring:message text="Dish"/>
            </form:label></td>
            <td><form:input path="dish_name"/></td>
        </tr>

        </tr>

        <tr>
            <td><form:label path="dish_price">
                <spring:message text="Price"/>
            </form:label></td>
            <td><form:input path="dish_price"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${user.userId != 0}">
                    <input type="submit" value="<spring:message text="Add Dish"/>"/>
                </c:if> <c:if test="${user.userId == 0}">
                <form:form method="GET" action="/home">
                    <table>
                        <tr>
                            <td>
                                <input type="submit" value="Save"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>


</body>
</html>
