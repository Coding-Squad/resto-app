<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<html>
<head>
    <title>Company Page</title>
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
<h1>Company Registration</h1>

<c:url var="addAction" value="/company/add"></c:url>

<form:form action="${addAction}" commandName="company">
    <table>
        <form:hidden path="companyId"/>
        <tr>
            <td><form:label path="name">
                <spring:message text="Name"/>
            </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="website">
                <spring:message text="Website"/>
            </form:label></td>
            <td><form:input path="website"/></td>
        </tr>
        <tr>
            <td><form:label path="address">
                <spring:message text="Address"/>
            </form:label></td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${company.companyId != 0}">
                    <input type="submit" value="<spring:message text="Update Company"/>"/>
                </c:if> <c:if test="${company.companyId == 0}">
                <input type="submit" value="<spring:message text="Save Company"/>"/>
            </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Company List</h3>
<c:if test="${!empty listCompany}">
    <table class="tg">
        <tr>
            <th width="80">Company ID</th>
            <th width="120">Company Name</th>
            <th width="120">Company Website</th>
            <th width="120">Company Address</th>
            <th width="120">Asset Count</th>
            <th width="120">Reader Count</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCompany}" var="company">
            <tr>
                <td>${company.companyId}</td>
                <td>${company.name}</td>
                <td>${company.website}</td>
                <td>${company.address}</td>
                <td>${fn:length(company.assets)}</td>
                <td>${fn:length(company.readers)}</td>
                <td><a href="<c:url value='/company/edit/${company.companyId}' />">Edit</a></td>
                <td><a href="<c:url value='/company/remove/${company.companyId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
