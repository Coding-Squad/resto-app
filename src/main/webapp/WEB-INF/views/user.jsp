
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>

    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>


<body>


<div>

    <h3>Creat</h3>


    <form:form commandName='user'
               action="/user/add" method='POST'>

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
                <spring:message text="Last Name"/>
            </form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>

        <tr>
            <td><form:label path="address">
                <spring:message text="Address"/>
            </form:label></td>
            <td><form:input path="address"/></td>
        </tr>

        <tr>
            <td><form:label path="phone">
                <spring:message text="Phone"/>
            </form:label></td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><form:label path="email">
                <spring:message text="Email"/>
            </form:label></td>
            <td><form:input path="email"/></td>
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
            <td><form:input path="password"/></td>
        </tr>

        <tr>
            <td><form:label path="authorities">
                <spring:message text="User Role"/>
            </form:label></td>
            <td> <form:select path="authorities">
                <form:option value="ROLE_USER" label="User" />
                <form:option value="ROLE_ADMIN"  label="Admin"/>
            </form:select>
            </td>
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
    <h3>User List</h3>
    <c:if test="${!empty listUser}">
    <table class="tg">
        <tr>
            <th width="80">User ID</th>
            <th width="120">First Name</th>
            <th width="120">Last Name</th>
            <th width="120">Address</th>
            <th width="120">Phone</th>
            <th width="120">Email</th>
            <th width="120">Username</th>
            <th width="60">Password</th>
            <th width="60">Authorities</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>

        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.address}</td>
                <td>${user.phone}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.authorities}</td>


                <td><a href="<c:url value='/user/edit/${user.userId}' />">Edit</a></td>
                <td><a href="<c:url value='/user/remove/${user.userId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</body>
</html>

