<%--
  Created by IntelliJ IDEA.
  User: Yumi
  Date: 7/7/2016
  Time: 11:13 AM
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
    <title>User Page</title>
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
</head>
<body>
<h1>User Registration</h1>

<c:url var="addAction" value="/user/add"></c:url>

<form:form action="${addAction}" commandName="user">
    <table>
        <form:hidden path="userId"/>
        <tr>
            <td><form:label path="firstName">
                <spring:message text="First Name"/>
            </form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>

        <tr>
            <td><form:label path="lastName">
                <spring:message text="Laste Name"/>
            </form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>

        <tr>
            <td><form:label path="role">
                <spring:message text="User Role"/>
            </form:label></td>
            <td> <form:select path="role">
                <form:option value="Role_User" label="User" />
                <form:option value="Role_Admin"  label="Admin"/>
            </form:select>
            </td>


        </tr>

        <tr>
            <td><form:label path="phone">
                <spring:message text="Phone Number"/>
            </form:label></td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><form:label path="email">
                <spring:message text="Email Address"/>
            </form:label></td>
            <td><form:input path="email"/></td>
        </tr>

        <tr>
            <td><form:label path="address">
                <spring:message text="Address"/>
            </form:label></td>
            <td><form:input path="address"/></td>
        </tr>

        <tr>
            <td><form:label path="username">
                <spring:message text="Username"/>
            </form:label></td>
            <td><form:input path="username"/></td>
        </tr>

        <tr>
            <td><form:label path="password">
                <spring:message text="Password"/>
            </form:label></td>
            <td><form:password path="password"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${user.userId != 0}">
                    <input type="submit" value="<spring:message text="Update User"/>"/>
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
