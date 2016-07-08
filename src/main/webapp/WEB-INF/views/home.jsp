<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Resto App
</h1>

<P> The time on the server is ${serverTime}. </P>

<form:form action="loginform">

    Username
    <input type="text" name="username"/><br>

    Password
    <input type="text" name="password"/>
    <br>
    <input type="submit" value="Login">

    </form>
    <form:form method="GET" action="/customer">
        <table>
            <tr>
                <td>
                    <input type="submit" value="Register"/>
                </td>
            </tr>
        </table>
    </form:form>


</body>
</html>
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Resto App
</h1>

<P> The time on the server is ${serverTime}. </P>


<c:if test="${param.error == 'true'}">
    <div style="color:red;margin:10px 0px;">

        Login Failed!!!<br />
        Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

    </div>
</c:if>

<h3>Enter username and password:</h3>

<form:form action="${pageContext.request.contextPath}loginForm" commandName="loginForm">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form:form>
<form:form method="GET" action="/user">
    <table>
        <tr>
            <td>
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>


