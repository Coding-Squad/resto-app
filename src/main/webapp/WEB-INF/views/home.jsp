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
    MOSHI MOSHI HOLA HOLA
</h1>

<P> The time on the server is ${serverTime}. </P>
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
