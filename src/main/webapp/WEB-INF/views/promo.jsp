<%--
  Created by IntelliJ IDEA.
  User: Rubyline
  Date: 8/2/2016
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<br>
<html>
<head>
    <title>Promo Page</title>
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
<h1>Promo Registration</h1>


<c:url var="addAction" value="/promo/add"></c:url>
<form:form action="/promo/add" commandName="promo">
    <table>
        <form:hidden path="promoId"/>
        <tr>
            <td><form:label path="meal">
                <spring:message text="Meal Name"/>
            </form:label></td>
            <td><form:select path="meal">
                <form:options items="${$ggg}"  />
            </form:select>
            </td>

        </tr>

        <tr>
            <td><form:label path="name">
                <spring:message text="Name"/>
            </form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="description">
                <spring:message text="Description"/>
            </form:label></td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td><form:label path="discount">
                <spring:message text="Discount"/>
            </form:label></td>
            <td><form:input path="discount"/></td>
        </tr>

        <tr>
            <td><form:label path="quantity">
                <spring:message text="Available Reservation"/>
            </form:label></td>
            <td><form:input path="quantity"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${promo.promoId != 0}">
                    <input type="submit" value="<spring:message text="Update Promo"/>"/>
                </c:if> <c:if test="${promo.promoId == 0}">
                <input type="submit" value="<spring:message text="Save Promo"/>"/>
            </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Meal List</h3>
<c:if test="${!empty listPromo}">
    <table class="tg">
        <tr>
            <th width="80">Promo ID</th>
            <th width="80">Meal ID</th>
            <th width="120">Name</th>
            <th width="120">Description</th>
            <th width="120">Discount</th>
            <th width="120">Available Reservation</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPromo}" var="meal">
            <tr>
                <td>${promo.promoId}</td>
                <td>${promo.mealId}</td>
                <td>${promo.name}</td>
                <td>${promo.description}</td>
                <td>${promo.discount}</td>
                <td>${promo.quantity}</td>
                <td><a href="<c:url value='/meal/edit/${promo.promoId}' />">Edit</a></td>
                <td><a href="<c:url value='/meal/remove/${promo.promoId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
