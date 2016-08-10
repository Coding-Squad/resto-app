
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<body>


<div id="login-box">

    <h3>Login with Username and Password</h3>

    <c:if test="${not empty error}">
    <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
    </c:if>

    <form:form name='loginForm'
          action="/login" method='POST'>

        <table>
            <tr>
                <td>Email:</td>
                <td><input type='text' name='email'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="Login" /></td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

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


