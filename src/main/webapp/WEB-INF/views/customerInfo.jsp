<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<html>
<head>
    <title>Customer Information</title>
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

<h3>Customer List</h3>
<c:if test="${!empty listCustomer}">
    <table class="tg">
    <tr>
    <th width="80">Customer ID</th>
    <th width="120">First Name</th>
    <th width="120">Last Name</th>
    <th width="120">Phone</th>
    <th width="120">Email</th>
    <th width="120">Address</th>
    <th width="120">Username</th>
    <th width="120">Password</th>
    <th width="60">Edit</th>
    <th width="60">Delete</th>
    </tr>

    <c:forEach items="${listCustomer}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>${customer.username}</td>
            <td>${customer.password}</td>
            <td><a href="<c:url value='/customer/edit/${customer.customerId}' />">Edit</a></td>
            <td><a href="<c:url value='/customer/remove/${customer.customerId}' />">Delete</a></td>
        </tr>
    </c:forEach>
        </c:if>
    </table>
</table>
</body>
</html>
