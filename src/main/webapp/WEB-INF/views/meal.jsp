<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<br>
<head>
    <title>Meal Page</title>
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
<h1>Meal Registration</h1>


<c:url var="addAction" value="/meal/add"></c:url>
<form:form action="/meal/add" commandName="meal">
    <table>
        <form:hidden path="mealId"/>


        <tr>
            <%--<form:input type="hidden" path="companyId" name="companyId" />--%>
            <td><form:label path="company">
                <spring:message text="Company Name"/>
            </form:label></td>
            <td><form:select path="company">
                <form:options items="${companyListName}"/>
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
            <td><form:label path="price">
                <spring:message text="Price"/>
            </form:label></td>
            <td><form:input path="price"/></td>
        </tr>

        <tr>
            <td><form:label path="quantity">
                <spring:message text="Available Reservation"/>
            </form:label></td>
            <td><form:input path="quantity"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${meal.mealId != 0}">
                    <input type="submit" value="<spring:message text="Update Meal"/>"/>
                </c:if> <c:if test="${meal.mealId == 0}">
                <input type="submit" value="<spring:message text="Save Meal"/>"/>
            </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Meal List</h3>
<c:if test="${!empty listMeal}">
    <table class="tg">
        <tr>
            <th width="80">Meal ID</th>
            <th width="80">Company ID</th>
            <th width="120">Name</th>
            <th width="120">Description</th>
            <th width="120">Price</th>
            <th width="120">Available Reservation</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listMeal}" var="meal">
            <tr>
                <td>${meal.mealId}</td>
                <td>${meal.companyId}</td>
                <td>${meal.name}</td>
                <td>${meal.description}</td>
                <td>${meal.price}</td>
                <td>${meal.quantity}</td>
                <td><a href="<c:url value='/meal/edit/${meal.mealId}' />">Edit</a></td>
                <td><a href="<c:url value='/meal/remove/${meal.mealId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>

</br>

</html>