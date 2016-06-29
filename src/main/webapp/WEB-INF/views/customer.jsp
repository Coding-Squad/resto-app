<%--
  Created by IntelliJ IDEA.
  User: Yumi
  Date: 6/23/2016
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<html>
<head>
    <title>Customer Page</title>
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
<h1>Customer Registration</h1>

<c:url var="addAction" value="/customer/add"></c:url>

<form:form action="${addAction}" commandName="customer">
    <table>
        <form:hidden path="customerId"/>
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
                <c:if test="${customer.customerId != 0}">
                    <input type="submit" value="<spring:message text="Update Customer"/>"/>
                </c:if> <c:if test="${customer.customerId == 0}">
                <input type="submit" value="<spring:message text="Save"/>"/>
            </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<%--
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
 </table>
</c:if>
 --%>
</body>
</html>
